/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.factory.simple;

import org.infrastructure.common.factory.CarBO;
import org.infrastructure.common.factory.CarTypeEnum;
import org.infrastructure.common.factory.SuvCarBO;
import org.infrastructure.common.factory.VanCarBO;

/**
 * 简单工厂示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class CarSimpleFactory {

    /**
     * 按车型制造车辆
     * 
     * @param carType
     * @return
     */
    public static CarBO createCar(CarTypeEnum carType) {
        switch (carType) {
        case SUV:
            return new SuvCarBO();
        case VAN:
            return new VanCarBO();
        default:
            break;
        }

        return null;
    }
}
