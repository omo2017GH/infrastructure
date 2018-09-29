/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.core;

/**
 * 策略工作者
 * 将策略的实施和策略上下文解耦，交由第三方处理
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
@FunctionalInterface
public interface JstrategyWorker {

    <T, R> R work(JstrategyContext context);
}
