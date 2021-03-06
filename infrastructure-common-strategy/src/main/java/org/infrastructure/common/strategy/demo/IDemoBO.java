/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.StrategyContext;

/**
 * 基于策略模式的业务对象的接口示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface IDemoBO extends StrategyContext {

    Long getId();
    String getCode();
}
