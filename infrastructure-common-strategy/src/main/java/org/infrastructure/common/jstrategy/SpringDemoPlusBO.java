/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

/**
 * 业务对象，内涵策略
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class SpringDemoPlusBO extends DemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7711789691995932214L;

    public SpringDemoPlusBO() {
        setJstrategy(new SpringDemoBOJstrategyImpl("springBeanNme"));
    }
}
