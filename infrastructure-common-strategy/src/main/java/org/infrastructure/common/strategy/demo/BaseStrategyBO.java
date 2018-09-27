/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.AbstractStrategyContext;
import org.infrastructure.common.strategy.core.Strategy;

/**  
 * <b>ClassName:</b> org.infrastructure.common.strategy.demo.BaseStrategyBO.java <br>  
 * <b>Description:</b> (用一句话介绍类的作用) <br> 
 * <b>Date:</b> 2018年9月27日 下午6:40:42 <br>  
 * @author zhihong.he <br>
 * @version 1.0 
 */
public abstract class BaseStrategyBO extends AbstractStrategyContext {

    private Strategy strategy;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return
     * @see org.infrastructure.common.strategy.core.StrategyContext#get()
     */
    @Override
    public Object get() {
        return this;
    }

    /**
     * @return
     * @see org.infrastructure.common.strategy.core.StrategyContext#getStrategy()
     */
    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
