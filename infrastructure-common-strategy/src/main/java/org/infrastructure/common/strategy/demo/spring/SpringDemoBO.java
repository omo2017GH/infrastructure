/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.demo.DemoBO;

/**  
 * <b>ClassName:</b> org.infrastructure.common.strategy.demo.spring.SpringDemoBO.java <br>  
 * <b>Description:</b> (用一句话介绍类的作用) <br> 
 * <b>Date:</b> 2018年9月27日 下午6:45:01 <br>  
 * @author zhihong.he <br>
 * @version 1.0 
 */
public class SpringDemoBO extends DemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1297294105690795398L;

    public SpringDemoBO() {
        setStrategy(new DemoSpringStrategy());
    }
}
