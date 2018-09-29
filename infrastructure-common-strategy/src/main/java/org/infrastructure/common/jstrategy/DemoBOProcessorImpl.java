/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.extension.spring.JspringStrategyProcessor;

/**
 * 服务端侧，策略实施者的代理示例
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class DemoBOProcessorImpl implements JspringStrategyProcessor<IdemoBO, Boolean> {

    @Override
    public Boolean process(IdemoBO target) {
        System.out.println("IdemoBO = " + target);
        return false;
    }

}
