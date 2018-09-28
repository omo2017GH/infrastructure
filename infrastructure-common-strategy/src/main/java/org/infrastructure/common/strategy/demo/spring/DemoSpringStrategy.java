/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.demo.IDemoBO;
import org.infrastructure.common.strategy.spring.StrategyForSpring;
import org.springframework.context.ApplicationContext;

/**
 * 基于Spring的策略示例
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class DemoSpringStrategy implements StrategyForSpring {

    /**
     * @param target
     * @see org.infrastructure.common.strategy.core.Strategy#execute(java.lang.Object)
     */
    @Override
    public void execute(Object target) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param target
     * @param applicationContext
     * @see org.infrastructure.common.strategy.spring.StrategyForSpring#execute(java.lang.Object, org.springframework.context.ApplicationContext)
     */
    @Override
    public void execute(Object target, ApplicationContext applicationContext) {
        if (!(target instanceof IDemoBO)) {
            System.out.println("target is not instanceof IDemoBO");
            return;
        }

        IDemoBO bo = (IDemoBO) target;
        System.out.println("IDemoBO = " + bo);
        System.out.println("ApplicationContext = " + applicationContext);
    }

}
