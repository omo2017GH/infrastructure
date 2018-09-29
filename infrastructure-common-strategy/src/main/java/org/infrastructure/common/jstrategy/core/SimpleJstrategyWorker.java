/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.core;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class SimpleJstrategyWorker implements JstrategyWorker {

    @Override
    public <T, R> R work(JstrategyContext context) {
        T target = context.get();
        if (target == null) {
            throw new NullPointerException("实行策略的对象为空");
        }

        Jstrategy<T, R> strategy = context.getStrategy();
        if (strategy == null) {
            throw new NullPointerException("策略为空");
        }

        return strategy.apply(target);
    }
}
