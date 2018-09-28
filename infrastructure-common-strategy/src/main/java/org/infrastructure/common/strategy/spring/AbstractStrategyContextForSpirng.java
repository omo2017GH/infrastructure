/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.spring;

import java.util.Optional;

import org.infrastructure.common.strategy.core.Strategy;
import org.infrastructure.common.strategy.core.StrategyContext;
import org.springframework.context.ApplicationContext;

/**
 * 基于spring实现的策略应用上下文基类
 * 
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public abstract class AbstractStrategyContextForSpirng implements StrategyContextForSpirng {

    private StrategyContext strategyContext;
    private ApplicationContext applicationContext;

    @Override
    public Object get() {
        return strategyContext.get();
    }

    /**
     * 
     * @see org.infrastructure.common.strategy.core.StrategyContext#execute()
     */
    @Override
    public void execute() {
        Optional<Strategy> strategyOP = Optional.ofNullable(getStrategy());
        Strategy strategy = strategyOP.orElseThrow(() -> new NullPointerException("策略为空"));
        if (!(strategy instanceof StrategyForSpring)) {
            System.out.println("strategy is not instanceof StrategyForSpring");
            return;
        }

        StrategyForSpring strategyForSpring = (StrategyForSpring) strategy;
        strategyForSpring.execute(get(), getApplicationContext());
    }

    @Override
    public Strategy getStrategy() {
        return strategyContext.getStrategy();
    }

    /**
     * @return the strategyContext
     */
    public StrategyContext getStrategyContext() {
        return strategyContext;
    }

    /**
     * @param strategyContext the strategyContext to set
     */
    public void setStrategyContext(StrategyContext strategyContext) {
        this.strategyContext = strategyContext;
    }

    /**
     * @return
     * @see org.infrastructure.common.strategy.spring.StrategyContextForSpirng#getApplicationContext()
     */
    @Override
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @param applicationContext the applicationContext to set
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
