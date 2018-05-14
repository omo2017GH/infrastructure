/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandContext;
import org.infrastructure.common.command.core.CommandExecutor;

/**
 * 
 * @date 2018年4月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public abstract class AbstractCommandExecutor implements CommandExecutor {

    /**
     * @param context
     * @return
     * @see org.infrastructure.common.command.core.common.cmd.CommandExecutor#execute(org.infrastructure.common.command.core.common.cmd.CommandContext)
     */
    @Override
    public int execute(CommandContext context) {
        AbstractLinkedCommandContext acc = null;
        try {
            acc = (AbstractLinkedCommandContext) context;
        } catch (Exception e) {
            throw new UnsupportedOperationException(
                "context must be instanceof " + AbstractLinkedCommandContext.class.getName());
        }
        Integer nextCmdOrder = run(acc);

        if (nextCmdOrder == null) {
            return acc.getNextOrder();
        } else {
            return nextCmdOrder;
        }
    }

    /**
     * 编写指令具体的实现逻辑<br>
     * 返回结果为null表示按照默认的指令顺序继续进行，若不为null则执行序列号对应的下一条指令
     * @param context 指令上下文
     * @return 下一条指令的序列号（null表示按照默认顺序继续执行）
     */
    protected abstract Integer run(AbstractLinkedCommandContext context);
}
