/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.demo.IDemoBO;
import org.infrastructure.common.strategy.spring.StrategyContextForSpirng;
import org.infrastructure.common.strategy.spring.StrategyContextForSpirngAdapter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <b>ClassName:</b> org.infrastructure.common.strategy.demo.spring.DemoSpingBizService.java <br>
 * <b>Description:</b> (用一句话介绍类的作用) <br>
 * <b>Date:</b> 2018年9月27日 下午6:49:03 <br>
 * 
 * @author zhihong.he <br>
 * @version 1.0
 */
public class DemoSpingBizService implements IDemoSpingBizService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * @param bo
     * @see org.infrastructure.common.strategy.demo.spring.IDemoSpingBizService#go(org.infrastructure.common.strategy.demo.IDemoBO)
     */
    @Override
    public void go(IDemoBO bo) {
        StrategyContextForSpirng strategyContextForSpirng = new StrategyContextForSpirngAdapter(bo, applicationContext);
        strategyContextForSpirng.execute();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
