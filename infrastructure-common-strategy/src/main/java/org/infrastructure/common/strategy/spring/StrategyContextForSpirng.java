/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.spring;

import org.infrastructure.common.strategy.core.StrategyContext;
import org.springframework.context.ApplicationContext;

/**
 * 基于spring实现的策略应用上下文，包含策略及策略实施的所需资源
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface StrategyContextForSpirng extends StrategyContext {

    /**
     * @return Spring 应用上下文
     */
    ApplicationContext getApplicationContext();
}
