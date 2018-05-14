/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandChain;
import org.infrastructure.common.command.core.CommandContext;
import org.infrastructure.common.command.core.CommandExecutor;

/**
 * 指令链基类
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public abstract class AbstractCommandChain implements LinkedCommandChain {

    final AbstractHeadCommandContext head;

    final AbstractTailCommandContext tail;

    public AbstractCommandChain(AbstractHeadCommandContext head, AbstractTailCommandContext tail) {
        this.head = head;
        this.tail = tail;
        head.setStep(tail.getOrder());

        // 双向列表
        head.nextCmdCtx = tail;
        tail.prevCmdCtx = head;
    }

    /**
     * @param name
     * @param executor
     * @return
     * @see org.infrastructure.common.command.core.CommandChain#addFirst(java.lang.String, org.infrastructure.common.command.core.CommandExecutor)
     */
    @Override
    public CommandChain addFirst(String name, CommandExecutor executor) {
        int newOrder = 0;
        int newNextOrder = newOrder + 1;

        AbstractLinkedCommandContext afterHead = head.nextCmdCtx;

        if (afterHead instanceof AbstractTailCommandContext) {
            newNextOrder = head.nextOrder;
            head.nextOrder = 0;
        } else {
            AbstractLinkedCommandContext next = afterHead;
            for(;;) {
                if (next instanceof AbstractTailCommandContext) {
                    next.prevCmdCtx.nextOrder = AbstractTailCommandContext.TAIL_ORDER;
                    break;
                }
                next.order = next.order + 1;
                next.nextOrder = next.nextOrder + 1;
                next = next.nextCmdCtx;
            }
        }

        return addFirst(name, newOrder, newNextOrder, executor);
    }

    /**
     * 在指令链的第一个位置添加元素
     * 
     * @param name 命令执行器的名称
     * @param order 当前命令执行器顺序编号（值越小优先等级越高）
     * @param nextOrder 下一条指令的命令执行器顺序编号（值越小优先等级越高）
     * @param executor 命令执行器
     * @return
     * @see org.infrastructure.common.command.core.common.cmd.CommandChain#addFirst(java.lang.String, int, int,
     *      org.infrastructure.common.command.core.common.cmd.CommandExecutor)
     */
    @Override
    public CommandChain addFirst(String name, int order, int nextOrder, CommandExecutor executor) {
        AbstractLinkedCommandContext newCmd = newCmd(name, order, nextOrder, executor);
        AbstractLinkedCommandContext headNextCmd = head.nextCmdCtx;
        newCmd.prevCmdCtx = head;
        newCmd.nextCmdCtx = headNextCmd;
        head.nextCmdCtx = newCmd;
        headNextCmd.prevCmdCtx = newCmd;

        return this;
    }

    /**
     * @return
     * @see org.infrastructure.common.command.core.common.cmd.CommandChain#executeCommand()
     */
    @Override
    public CommandChain executeCommand() {
        CommandContext execute = head.execute();
        while (execute != null) {
            execute = execute.execute();
        }
        return this;
    }

    /**
     * @param name
     * @param order
     * @param nextOrder
     * @param executor
     * @return
     */
    protected abstract AbstractLinkedCommandContext newCmd(String name, int order, int nextOrder,
        CommandExecutor executor);
}
