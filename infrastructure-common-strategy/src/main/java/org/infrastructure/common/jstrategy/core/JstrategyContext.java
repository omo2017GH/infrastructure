/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.core;

/**
 * 策略应用上下文，包含策略及策略实施的所需资源
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface JstrategyContext {

    /**
     * 策略实施的目标对象
     * @return
     */
    <T> T get();

    /**
     * 策略
     * @return
     */
    <T, R> Jstrategy<T, R> getStrategy();

}
