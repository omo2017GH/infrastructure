/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.spring;

import org.infrastructure.common.strategy.core.StrategyContext;
import org.springframework.context.ApplicationContext;

/**
 * 基于spring实现的策略应用上下文适配器
 * 
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class StrategyContextForSpirngAdapter extends AbstractStrategyContextForSpirng {

    public StrategyContextForSpirngAdapter() {}

    public StrategyContextForSpirngAdapter(StrategyContext strategyContext) {
        this(strategyContext, null);
    }

    public StrategyContextForSpirngAdapter(ApplicationContext applicationContext) {
        this(null, applicationContext);
    }

    public StrategyContextForSpirngAdapter(StrategyContext strategyContext, ApplicationContext applicationContext) {
        setStrategyContext(strategyContext);
        setApplicationContext(applicationContext);
    }
}
