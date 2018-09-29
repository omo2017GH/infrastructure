/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.extension.spring.SimpleJspringStrategyWorker;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class JspringStrategyTest {

    @Test
    public void test() {
        SimpleJspringStrategyWorker worker = new SimpleJspringStrategyWorker();
        worker.setApplicationContext(new DemoApplicationContext());
        SpringDemoPlusBO bo = new SpringDemoPlusBO();
        bo.setId(2L);
        bo.setCode("b");
        Boolean suc = worker.work(bo);
        Assert.assertFalse(suc);
    }
}
