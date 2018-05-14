/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

/**
 * StrategyContext包装器
 * @date 2018年5月10日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface StrategyContextWrapper<T> extends StrategyContext {

    /**
     * 包装器内嵌的StrategyContext
     * @return
     */
    StrategyContext getOriginalStrategyContext();

    /**
     * 策略依赖项
     * @return
     */
    T getStrategyDependency();
}
