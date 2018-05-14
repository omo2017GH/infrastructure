/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.extension;

import org.infrastructure.common.command.core.CommandChain;
import org.infrastructure.common.command.core.CommandExecutor;

/**
 * 
 * @date 2018年5月3日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface LinkedCommandChain extends CommandChain {

    /**
     * 在指令链的第一个位置添加元素
     * @param name 命令执行器的名称
     * @param order 当前命令执行器顺序编号（值越小优先等级越高）
     * @param nextOrder 下一条指令的命令执行器顺序编号（值越小优先等级越高）
     * @param executor 命令执行器
     * @return
     */
    CommandChain addFirst(String name, int order, int nextOrder, CommandExecutor executor);

}
