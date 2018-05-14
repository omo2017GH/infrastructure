/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy;

import org.infrastructure.common.strategy.core.Strategy;

/**
 * 
 * @date 2018年5月7日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class BeanBOContext extends BeanBO implements IBeanBOContext {

    private Strategy localStrategy;

    public BeanBOContext() {
        this(new BeanBOStrategy());
    }

    public BeanBOContext(Strategy strategy) {
        localStrategy = strategy;
    }

    /**
     * @return
     * @see org.infrastructure.common.strategy.core.StrategyContext#getStrategy()
     */
    @Override
    public Strategy getStrategy() {
        return localStrategy;
    }
}
