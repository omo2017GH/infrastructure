/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.CommandContextUtils;
import org.infrastructure.common.command.core.CommandContext;
import org.infrastructure.common.command.core.CommandExecutor;

/**
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class DefaultCommandChain extends AbstractCommandChain {

    private final Object obj;

    public DefaultCommandChain(int headNextStep, Object obj) {
        super(new HeadCommandContext(headNextStep, obj), new TailCommandContext(obj));
        this.obj = obj;
    }

    public DefaultCommandChain(Object obj) {
        super(new HeadCommandContext(AbstractTailCommandContext.TAIL_ORDER, obj), new TailCommandContext(obj));
        this.obj = obj;
    }

    public DefaultCommandChain(int headNextStep) {
        this(headNextStep, null);
    }

    public DefaultCommandChain() {
        this(AbstractTailCommandContext.TAIL_ORDER);
    }

    /**
     * @param name
     * @param order
     * @param executor
     * @return
     * @see org.infrastructure.common.command.extension.common.cmd.AbstractCommandChain#newCmd(java.lang.String, int,
     *      org.infrastructure.common.command.core.common.cmd.CommandExecutor)
     */
    @Override
    protected AbstractLinkedCommandContext newCmd(String name, int order, int nextOrder, CommandExecutor executor) {
        return CommandContextUtils.newDefaultCommandContext(name, order, nextOrder, executor, obj);
    }

    static final class HeadCommandContext extends AbstractHeadCommandContext implements CommandExecutor {

        private final Object obj;

        private static final int DEFAULT_NEXT_STEP = 0;

        HeadCommandContext(Object args) {
            this(DEFAULT_NEXT_STEP, args);
        }

        HeadCommandContext(int headResult, Object obj) {
            super(headResult);
            this.obj = obj;
        }

        @Override
        public CommandExecutor getCommandExecutor() {
            return this;
        }

        @Override
        public int execute(CommandContext context) {
            System.out.println(getName());
            return this.getNextOrder();
        }

        @Override
        public Object getObject() {
            return obj;
        }

        @Override
        public void setObject(Object obj) {}
    }

    static final class TailCommandContext extends AbstractTailCommandContext implements CommandExecutor {

        private final Object obj;

        TailCommandContext(Object obj) {
            super();
            this.obj = obj;
        }

        @Override
        public CommandExecutor getCommandExecutor() {
            return this;
        }

        @Override
        public int execute(CommandContext context) {
            System.out.println(getName());
            return this.getNextOrder();
        }

        @Override
        public Object getObject() {
            return obj;
        }

        @Override
        public void setObject(Object obj) {}
    }
}
