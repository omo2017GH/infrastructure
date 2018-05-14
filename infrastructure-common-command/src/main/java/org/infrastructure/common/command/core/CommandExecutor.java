/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.core;

/**
 * 命令执行器
 * 执行单条命令
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface CommandExecutor {

    /**
     * 根据命令的上下文执行此命令
     * @param context 命令上下文
     */
    int execute(CommandContext context);
}
