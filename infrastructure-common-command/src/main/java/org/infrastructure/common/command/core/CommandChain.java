/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.core;

/**
 * 指令链
 * 将多条命令串联起来并按序执行
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface CommandChain {

    /**
     * 在指令链的第一个位置添加元素
     * @param name 命令执行器的名称
     * @param order 当前命令执行器顺序编号（值越小优先等级越高）
     * @param nextOrder 下一条指令的命令执行器顺序编号（值越小优先等级越高）
     * @param executor 命令执行器
     * @return
     */
    CommandChain addFirst(String name, CommandExecutor executor);

    /**
     * 按序执行指令链
     * @return
     */
    CommandChain executeCommand();
}
