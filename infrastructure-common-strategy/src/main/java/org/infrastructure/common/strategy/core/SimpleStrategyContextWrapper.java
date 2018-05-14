/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

import org.springframework.context.ApplicationContext;

/**
 * 
 * @date 2018年5月10日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class SimpleStrategyContextWrapper extends AbstractStrategyContextWrapper {

    protected StrategyContext strategyContext;

    public SimpleStrategyContextWrapper(StrategyContext strategyContext, ApplicationContext applicationContext) {
        this.strategyContext = strategyContext;
        super.applicationContext = applicationContext;
    }

    /**
     * @return
     * @see org.infrastructure.common.strategy.core.StrategyContext#getStrategy()
     */
    @Override
    public Strategy getStrategy() {
        return strategyContext.getStrategy();
    }

    @Override
    public StrategyContext getOriginalStrategyContext() {
        return strategyContext;
    }

}
