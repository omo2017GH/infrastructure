/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.method;

import org.infrastructure.common.factory.CarBO;

/**
 * 工厂方法示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface CarFactoryMethod {

    /**
     * 制造车辆
     * 
     * @param carType
     * @return
     */
    CarBO createCar();
}
