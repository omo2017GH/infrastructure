/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.spring.StrategyContextForSpirng;
import org.infrastructure.common.strategy.spring.StrategyContextForSpirngAdapter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 基于Spring策略模式的业务服务示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class DemoSpingBizService implements IDemoSpingBizService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * @param bo
     * @see org.infrastructure.common.strategy.demo.spring.IDemoSpingBizService#go(org.infrastructure.common.strategy.demo.IDemoBO)
     */
    @Override
    public void go(ISpringDemoBO bo) {
        // 这里有适配器模式的影子，将 IDemoBO(StrategyContext) 和 applicationContext 适配成一个新的 StrategyContextForSpirng 接口
        StrategyContextForSpirng strategyContextForSpirng = new StrategyContextForSpirngAdapter(bo, applicationContext);
        strategyContextForSpirng.execute();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
