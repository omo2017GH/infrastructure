/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.extension.spring.AbstractJspringStrategy;

/**
 * 客户端侧，基于Spring策略模式，beanName传递给服务端，寻找对应的服务实例，由策略代理这处理
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class SpringDemoBOJstrategyImpl extends AbstractJspringStrategy<IdemoBO, Boolean> {

    public SpringDemoBOJstrategyImpl(String beanName) {
        super(beanName);
    }

}
