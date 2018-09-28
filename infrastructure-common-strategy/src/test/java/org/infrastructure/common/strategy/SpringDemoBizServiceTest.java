/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy;

import org.infrastructure.common.strategy.demo.spring.DemoSpingBizService;
import org.infrastructure.common.strategy.demo.spring.IDemoSpingBizService;
import org.infrastructure.common.strategy.demo.spring.SpringDemoBO;
import org.testng.annotations.Test;

/**
 * 基于Spring策略模式测试类
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class SpringDemoBizServiceTest {

    @Test
    public void test() {
        SpringDemoBO bo = new SpringDemoBO();
        bo.setId(1L);
        bo.setCode("a");
        IDemoSpingBizService ser = new DemoSpingBizService();
        ser.go(bo);
    }

}
