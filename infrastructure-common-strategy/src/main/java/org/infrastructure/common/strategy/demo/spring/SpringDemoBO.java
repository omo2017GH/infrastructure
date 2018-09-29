/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.demo.DemoBO;

/**
 * 基于Spirng的策略模式业务对象示例
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class SpringDemoBO extends DemoBO implements ISpringDemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1297294105690795398L;

    public SpringDemoBO() {
        // 策略对业务透明，由服务方封装策略
        setStrategy(new DemoSpringStrategy());
    }

}
