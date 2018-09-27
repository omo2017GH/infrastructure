/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.StrategyContext;

/**
 * 
 * @date 2018年5月7日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public interface IDemoBO extends StrategyContext {

    Long getId();
    String getCode();
}
