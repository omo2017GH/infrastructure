/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy.spring;

/**
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface SpringBeanNameExtractor {

    /**
     * @return Spring容器中对应的BeanName
     */
    String getServiceName();

}
