/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.extension.spring;

import org.infrastructure.common.jstrategy.core.Jstrategy;
import org.infrastructure.common.jstrategy.core.JstrategyContext;
import org.infrastructure.common.jstrategy.core.JstrategyWorker;
import org.springframework.context.ApplicationContext;

/**
 * 基于Spring的策略工作者
 * 通过 beanName 找到 {@code ApplicationContext} 中策略处理器 {@code JspringStrategyProcessor}
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public abstract class AbstractJspringStrategyWorker implements JstrategyWorker {

    @SuppressWarnings("unchecked")
    @Override
    public <T, R> R work(JstrategyContext context) {
        Jstrategy<T, R> strategy = context.getStrategy();
        if (!(strategy instanceof JspringStrategy)) {
            throw new IllegalArgumentException("strategy is not instanceof JspringStrategy");
        }

        JspringStrategy<T, R> jspringStrategy = (JspringStrategy<T, R>) strategy;
        String beanName = jspringStrategy.getBeanName();
        T target = context.get();

        JspringStrategyProcessor<T, R> bean = getApplicationContext().getBean(beanName, JspringStrategyProcessor.class);
        return bean.process(target);
    }

    protected abstract ApplicationContext getApplicationContext();
}
