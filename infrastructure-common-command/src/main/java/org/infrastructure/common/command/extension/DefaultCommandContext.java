/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandExecutor;

/**
 * 默认命令上下文
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class DefaultCommandContext extends AbstractLinkedCommandContext {

    private Object obj;

    private final CommandExecutor executor;

    /**
     * @param name
     * @param executor
     * @param order current cmd order
     */
    public DefaultCommandContext(final String name, final int order, final int nextOrder,
        final CommandExecutor executor, Object obj) {
        super(name, order, nextOrder);
        this.executor = executor;
        this.obj = obj;
    }

    /**
     * @return
     * @see org.infrastructure.common.command.core.common.cmd.CommandContext#getCommandExecutor()
     */
    @Override
    public CommandExecutor getCommandExecutor() {
        return executor;
    }

    /**
     * @return
     * @see org.infrastructure.common.command.extension.AbstractLinkedCommandContext.cmd.AbstractCommandContext#getObject()
     */
    @Override
    public Object getObject() {
        return obj;
    }

    @Override
    public void setObject(Object obj) {
        this.obj = obj;
    }

}
