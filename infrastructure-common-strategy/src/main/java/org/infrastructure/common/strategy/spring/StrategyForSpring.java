/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.spring;

import org.infrastructure.common.strategy.core.Strategy;
import org.springframework.context.ApplicationContext;

/**
 * 基于Spring实现的策略模式接口类，此类负责策略的实施
 * @date 2018年9月25日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface StrategyForSpring extends Strategy {

    /**
     * 实施策略
     * @param target 执行对象
     * @param target spring应用上下文
     */
    void execute(Object target, ApplicationContext applicationContext);

}
