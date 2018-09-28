/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy;

import org.infrastructure.common.strategy.demo.DemoBO;
import org.infrastructure.common.strategy.demo.DemoBizService;
import org.infrastructure.common.strategy.demo.DemoStrategy;
import org.infrastructure.common.strategy.demo.IDemoBizService;
import org.testng.annotations.Test;

/**
 * 策略模式测试类
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class DemoBizServiceTest {

    @Test
    public void test() {
        DemoBO bo = new DemoBO();
        bo.setId(2L);
        bo.setCode("b");
        // 由调用方决定何种策略
        bo.setStrategy(new DemoStrategy());
        IDemoBizService ser = new DemoBizService();
        ser.go(bo);
    }

}
