/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.core;

/**
 * 指令上下文
 * 存储与命令相关的状态及数据
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface CommandContext {

    /**
     * 与命令上下文关联的命令执行器
     * @return
     */
    CommandExecutor getCommandExecutor();

    /**
     * 执行命令
     * @return
     */
    CommandContext execute();
}
