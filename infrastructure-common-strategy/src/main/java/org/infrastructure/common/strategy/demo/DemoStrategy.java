/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.Strategy;

/**
 * 策略示例
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class DemoStrategy implements Strategy {

    /**
     * @param target
     * @see org.infrastructure.common.strategy.core.Strategy#execute(java.lang.Object)
     */
    @Override
    public void execute(Object target) {
        IDemoBO bo = (IDemoBO) target;
        System.out.println("IDemoBO = " + bo);
    }

}
