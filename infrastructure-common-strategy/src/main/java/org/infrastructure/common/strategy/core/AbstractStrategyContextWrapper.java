/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.core;

import org.springframework.context.ApplicationContext;

/**
 * 
 * @date 2018年5月14日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public abstract class AbstractStrategyContextWrapper implements StrategyContextWrapper<ApplicationContext> {

    protected ApplicationContext applicationContext;

    @Override
    public ApplicationContext getStrategyDependency() {
        return applicationContext;
    }

}
