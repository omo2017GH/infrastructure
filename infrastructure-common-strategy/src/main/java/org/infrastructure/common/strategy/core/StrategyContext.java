/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

/**
 * 策略应用上下文，包含策略及策略实施的所需资源
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface StrategyContext {

    /**
     * 被执行的对象
     * @return
     */
    Object get();

    /**
     * 策略
     * @return
     */
    Strategy getStrategy();

    /**
     * 执行策略，{@code Strategy#execute(StrategyContext)} 的代理方法
     */
    void execute();
}
