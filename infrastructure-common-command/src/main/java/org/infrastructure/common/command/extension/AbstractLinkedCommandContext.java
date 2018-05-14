/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandContext;
import org.springframework.core.PriorityOrdered;

/**
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public abstract class AbstractLinkedCommandContext implements LinkedCommandContext {

    /**
     * 上一条指令上下文
     */
    AbstractLinkedCommandContext prevCmdCtx;

    /**
     * 下一条指令上下文
     */
    AbstractLinkedCommandContext nextCmdCtx;

    /**
     * 指令的名称
     */
    private final String name;

    /**
     * 指令步骤
     * <ol>
     * <li>step = order, 执行器生效
     * <li>step &gt; order, 向后查找执行器
     * <li>step &lt; order, 向前查找执行器
     * </ol>
     * 
     * @return
     * @see org.springframework.core.Ordered#getOrder()
     */
    int step;

    /**
     * 当前指令的序列号
     */
    int order;

    /**
     * 下一条执行指令的序列号（默认按指令序列号顺序执行）
     */
    int nextOrder;

    AbstractLinkedCommandContext(final String name, final int order, final int nextOrder) {
        this.name = name;
        this.order = order;
        this.nextOrder = nextOrder;
    }

    /**
     * @return
     * @see org.infrastructure.common.command.core.common.cmd.CommandContext#execute()
     */
    @Override
    public CommandContext execute() {
        if (this instanceof AbstractHeadCommandContext) {
            int headNextStep = getCommandExecutor().execute(this);
            if (this.nextCmdCtx != null) {
                this.nextCmdCtx.setStep(headNextStep);
            }
        }

        AbstractLinkedCommandContext nextCmdCtx = getNextCommandContext();
        if (nextCmdCtx != null) {
            nextCmdCtx.execute0();
        }

        if (nextCmdCtx instanceof AbstractTailCommandContext) {
            return null;
        }

        return nextCmdCtx;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     * @see org.springframework.core.Ordered#getOrder()
     */
    @Override
    public int getOrder() {
        return order;
    }

    /**
     * @return the nextOrder
     */
    @Override
    public int getNextOrder() {
        return nextOrder;
    }

    /**
     * @return the prevCmd
     */
    @Override
    public AbstractLinkedCommandContext getPrevCmdCtx() {
        return prevCmdCtx;
    }

    /**
     * @return the nextCmd
     */
    @Override
    public AbstractLinkedCommandContext getNextCmdCtx() {
        return nextCmdCtx;
    }

    /**
     * @return the step
     */
    final int getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    final void setStep(int step) {
        this.step = step;
    }

    /**
     * 获取当前执行器上下文的内嵌对象
     */
    public abstract Object getObject();

    /**
     * 设置当前执行器上下文的内嵌对象
     * 
     * @param obj
     */
    public abstract void setObject(Object obj);

    /**
     * 将内嵌对象传播到每一个播执行器上下文中去
     * 
     * @param obj
     */
    public void propagateObject(Object obj) {
        setObject(obj);

        // 向前传播obj
        AbstractLinkedCommandContext prev = this;
        for (;;) {
            prev = prev.getPrevCmdCtx();
            if (prev != null) {
                prev.setObject(obj);
            } else {
                break;
            }
        }
        // 向后传播obj
        AbstractLinkedCommandContext next = this;
        for (;;) {
            next = next.getNextCmdCtx();
            if (next != null) {
                next.setObject(obj);
            } else {
                break;
            }
        }
    }

    private void execute0() {
        int nextStep = getStep();
        int currentOrder = getOrder();

        if (nextStep == currentOrder) {
            nextStep = getCommandExecutor().execute(this);
        }

        if (nextStep == PriorityOrdered.HIGHEST_PRECEDENCE) {
            throw new IllegalArgumentException("指令执行器下一指令序列号不能为头结点的序列号.[name=" + getName() + "]");
        }

        if (nextStep > currentOrder) {
            setCmdStep(this.nextCmdCtx, nextStep);
        } else if (nextStep < currentOrder) {
            setCmdStep(this.prevCmdCtx, nextStep);
        }
    }

    private void setCmdStep(AbstractLinkedCommandContext cmd, int nextStep) {
        if (cmd != null) {
            cmd.setStep(nextStep);
        }
    }

    private AbstractLinkedCommandContext getNextCommandContext() {
        if (this.nextCmdCtx != null && this.nextCmdCtx.step > this.order) {
            return this.nextCmdCtx;
        } else if (this.prevCmdCtx != null && this.prevCmdCtx.step < this.order) {
            return this.prevCmdCtx;
        }

        return null;
    }
}
