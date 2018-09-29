/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.extension.spring;

/**
 * 基于Spring扩展的策略模式基类
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public abstract class AbstractJspringStrategy<T, R> implements JspringStrategy<T, R> {

    public AbstractJspringStrategy(String beanName) {
        this.beanName = beanName;
    }

    private String beanName;

    @Override
    public R apply(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBeanName() {
        return beanName;
    }
}
