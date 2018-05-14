/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy;

import org.infrastructure.common.strategy.core.SimpleStrategyContextWrapper;
import org.infrastructure.common.strategy.core.StrategyContextWrapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * @date 2018年5月7日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
@Service
public class BeanBOService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void test(IBeanBOContext boCtx) {
        StrategyContextWrapper appStrategyCtx = new SimpleStrategyContextWrapper(boCtx, applicationContext);
        boCtx.getStrategy().execute(appStrategyCtx);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
