/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

/**
 * 账户原子操作接口环境角色
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface StrategyContext {

    /**
     * 策略
     * @return
     */
    Strategy getStrategy();
}
