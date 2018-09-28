/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.method;

import org.infrastructure.common.factory.CarTypeEnum;

/**
 * 汽车工厂路由器
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class CarFactoryRouter {

    /**
     * 按车辆类型寻找工厂
     * @param carType
     * @return
     */
    public static CarFactoryMethod getFactory(CarTypeEnum carType) {
        switch (carType) {
        case SUV:
            return new SuvCarFactoryImpl();
        case VAN:
            return new VanCarFactoryImpl();
        default:
            break;
        }

        throw new IllegalArgumentException("无法匹配到 carType 是 " + carType + " 的工厂");
    }
}
