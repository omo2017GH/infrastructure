/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandContext;
import org.springframework.core.PriorityOrdered;

/**
 * 指令链上下文，链式结构，可获取上一条及下一条指令的上下文
 * @date 2018年5月3日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface LinkedCommandContext extends CommandContext, PriorityOrdered {

    /**
     * 上一条指令上下文
     */
    LinkedCommandContext getPrevCmdCtx();

    /**
     * 下一条指令上下文
     */
    LinkedCommandContext getNextCmdCtx();

    /**
     * 下一条执行指令的序列号（默认按指令序列号顺序执行）
     */
    int getNextOrder();
}
