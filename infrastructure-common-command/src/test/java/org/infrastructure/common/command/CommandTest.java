/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */

package org.infrastructure.common.command;

import java.util.HashMap;
import java.util.Map;

import org.infrastructure.common.command.extension.DefaultCommandChain;
import org.springframework.core.PriorityOrdered;
import org.testng.annotations.Test;

/**
 * 
 * @date 2018年4月27日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class CommandTest {

    @Test
    public void test0() {
        int firstOrderIndex = 0;
        int tailOrderIndex = PriorityOrdered.LOWEST_PRECEDENCE;
        Map<String, String> args = new HashMap<>(10);
        DefaultCommandChain dcc = new DefaultCommandChain(firstOrderIndex, args);
        dcc.addFirst("cmd3", 3, tailOrderIndex, new DefaultCommandExecutor("cmd3"));
        dcc.addFirst("cmd2", 2, tailOrderIndex, new DefaultCommandExecutor("cmd2"));
        dcc.addFirst("cmd1", 1, 2, new DefaultCommandExecutor("cmd1"));
        dcc.addFirst("cmd0", 0, 1, new DefaultCommandExecutor("cmd0"));
        dcc.executeCommand();
    }

    @Test
    public static void test1() {
        int firstOrderIndex = 0;
        int tailOrderIndex = PriorityOrdered.LOWEST_PRECEDENCE;

        DefaultCommandChain dcc = new DefaultCommandChain(firstOrderIndex, null);

        dcc.addFirst("D5-0", 2, 1, new DefaultCommandExecutor5("D5-0"));
        dcc.addFirst("D4-0", 1, tailOrderIndex, new DefaultCommandExecutor4("D4-0"));
        dcc.addFirst("D3-0", 0, 1, new DefaultCommandExecutor3("D3-0"));
        dcc.executeCommand();
    }

    @Test
    public static void test2() {
        DefaultCommandChain dcc = new DefaultCommandChain();

        dcc.addFirst("D3-0", new DefaultCommandExecutor3("D3-0"));
        dcc.addFirst("D2-0", new DefaultCommandExecutor2("D2-0"));
        dcc.addFirst("D1-0", new DefaultCommandExecutor("D1-0"));
        dcc.executeCommand();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {}
}
