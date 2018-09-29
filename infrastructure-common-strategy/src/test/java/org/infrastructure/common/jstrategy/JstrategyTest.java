/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.core.JstrategyWorker;
import org.infrastructure.common.jstrategy.core.SimpleJstrategyWorker;
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
public class JstrategyTest {

    @Test
    public void test() {
        JstrategyWorker worker = new SimpleJstrategyWorker();
        DemoBO bo = new DemoPlusBO();
        bo.setId(1L);
        bo.setCode("a");
//        Jstrategy<IdemoBO> jstrategy = new DemoBOJstrategyImpl();
//        bo.setJstrategy(jstrategy);
        Boolean suc = worker.work(bo);
        Assert.assertTrue(suc);
    }
}
