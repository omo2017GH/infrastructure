/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command;

import java.util.ArrayList;
import java.util.List;

import org.infrastructure.common.command.core.CommandContext;
import org.infrastructure.common.command.core.CommandExecutor;
import org.infrastructure.common.command.extension.AbstractLinkedCommandContext;

/**
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class DefaultCommandExecutor4 implements CommandExecutor {

    /**
     * @param name 执行器名称
     * @param defaultNextCmdOrder 设置默认返回结果，下一个执行器的序号
     */
    public DefaultCommandExecutor4(String name) {
        this.name = name;
    }

    private final String name;

    @Override
    public int execute(CommandContext context) {
        AbstractLinkedCommandContext ac = (AbstractLinkedCommandContext) context;
        System.out.println("name = " + name + ", obj = " + ac.getObject());
        return ac.getNextOrder();
    }
}
