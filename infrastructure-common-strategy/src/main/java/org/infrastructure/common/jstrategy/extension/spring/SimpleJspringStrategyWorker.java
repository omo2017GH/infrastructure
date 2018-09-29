/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.extension.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
@Service("simpleJspringStrategyWorker")
public class SimpleJspringStrategyWorker extends AbstractJspringStrategyWorker implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /*
     * (non-Javadoc)
     * 
     * @see org.infrastructure.common.jstrategy.extension.spring.
     * AbstractJspringStrategyWorker#getApplicationContext()
     */
    @Override
    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
