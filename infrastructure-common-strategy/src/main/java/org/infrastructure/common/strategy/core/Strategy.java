/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

/**
 * 
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface Strategy {

    /**
     * 策略实施
     * @param t
     * @return
     */
    Object execute(StrategyContext context);

}
