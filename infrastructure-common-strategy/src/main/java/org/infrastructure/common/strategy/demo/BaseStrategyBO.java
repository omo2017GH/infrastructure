/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.AbstractStrategyContext;
import org.infrastructure.common.strategy.core.Strategy;

/**
 * 基于策略模式的业务对象，在普通的业务模型中嵌入策略，业务在确定模型的同时也能确定使用何种策略
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
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
