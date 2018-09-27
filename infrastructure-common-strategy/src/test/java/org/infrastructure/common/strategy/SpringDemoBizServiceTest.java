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
 * <b>ClassName:</b> org.infrastructure.common.strategy.SpringDemoBizServiceTest.java <br>  
 * <b>Description:</b> (用一句话介绍类的作用) <br> 
 * <b>Date:</b> 2018年9月27日 下午3:58:22 <br>  
 * @author zhihong.he <br>
 * @version 1.0 
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
