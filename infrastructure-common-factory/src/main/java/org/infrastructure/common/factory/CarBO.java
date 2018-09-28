/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory;

import java.math.BigDecimal;

/**
 * 工厂模式产品对象Car接口
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface CarBO {

    Integer getTopSpeed();

    BigDecimal getPrice();
}
