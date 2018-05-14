/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command;

import org.infrastructure.common.command.core.CommandExecutor;
import org.infrastructure.common.command.extension.DefaultCommandContext;

/**
 * 
 * @date 2018年4月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class CommandContextUtils {

    /**
     * create a new DefaultCommandContext
     * @param name
     * @param order
     * @param executor
     * @param nextOrder
     * @param args
     * @return
     */
    public static final  DefaultCommandContext newDefaultCommandContext(String name, int order, int nextOrder, CommandExecutor executor, Object args) {
        return new DefaultCommandContext(name, order, nextOrder, executor, args);
    }
}
