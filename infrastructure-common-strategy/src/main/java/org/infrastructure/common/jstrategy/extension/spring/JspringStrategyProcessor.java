/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.extension.spring;

/**
 * 基于Spring的策略处理器
 * 策略是客户端决定的，但是服务不会暴露在客户端，所以策略的实施由此类做了代理处理
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface JspringStrategyProcessor<T, R> {

    R process(T target);

}
