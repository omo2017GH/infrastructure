/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package org.infrastructure.common.strategy.core;

import java.util.Optional;

import cn.com.omo.infrastructure.common.model.base.BaseJavaBean;

/**
 * 策略应用上下文基类，包含基本的策略设置及策略执行
 * 
 * @date 2018年4月21日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public abstract class AbstractStrategyContext extends BaseJavaBean implements StrategyContext {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @see org.infrastructure.common.strategy.core.StrategyContext#execute()
     */
    @Override
    public void execute() {
        Optional<Strategy> strategyOP = Optional.ofNullable(getStrategy());
        Strategy strategy = strategyOP.orElseThrow(() -> new NullPointerException("策略为空"));
        Object target = get();
        strategy.execute(target);
    }
}
