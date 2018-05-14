/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy;

import org.infrastructure.common.strategy.core.AbstractStrategyContextWrapper;
import org.infrastructure.common.strategy.core.Strategy;
import org.infrastructure.common.strategy.core.StrategyContext;

/**
 * 
 * @date 2018年5月7日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
public class BeanBOStrategy implements Strategy {

    /**
     * @param context
     * @return
     * @see org.infrastructure.common.strategy.core.Strategy#execute(org.infrastructure.common.strategy.core.StrategyContext)
     */
    @Override
    public Object execute(StrategyContext context) {
        AbstractStrategyContextWrapper wrapper = (AbstractStrategyContextWrapper) context;
        BeanService beanService = wrapper.getStrategyDependency().getBean("beanServiceDemo", BeanService.class);
        BeanBOContext req = (BeanBOContext) wrapper.getOriginalStrategyContext();
        beanService.test(req);
        System.out.println("do the strategy");
        return Boolean.TRUE;
    }

}
