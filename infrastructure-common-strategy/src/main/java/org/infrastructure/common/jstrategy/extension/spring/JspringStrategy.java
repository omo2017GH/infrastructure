/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.extension.spring;

import org.infrastructure.common.jstrategy.core.Jstrategy;

/**
 * 基于Spring扩展的策略模式。
 * 策略是由客户端决定的，但服务的实例只存在于服务端（如果服务端是Spring框架，则实例就是SpringBean）
 * 客户端决定的策略实际上就是SpringBean的选择，通过BeanName传递给服务端，服务端通过ApplicationContext寻找Bean实例
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface JspringStrategy<T, R> extends Jstrategy<T, R> {

    /**
     * SpringBeanName
     * @return SpringBeanName
     */
    String getBeanName();
}
