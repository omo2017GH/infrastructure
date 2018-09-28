/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.abstraction;

import org.infrastructure.common.factory.CarBO;
import org.infrastructure.common.factory.CarTypeEnum;
import org.infrastructure.common.factory.SuvCarBO;
import org.infrastructure.common.factory.VanCarBO;

/**
 * 汽车配件装配器
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class CarCreator {

    /**
     * 按车型选择汽车工厂并组装车辆
     * @param carType
     * @return
     */
    public static CarBO createCar(CarTypeEnum carType) {
        CarAbstractionFactory factory = null;
        switch (carType) {
        case SUV:
            factory = new SuvCarAbstractionFactoryImpl();
            SuvCarBO suvCarBO = new SuvCarBO();
            suvCarBO.setTopSpeed(factory.createEngine());
            suvCarBO.setPrice(factory.createSkeleton());
            return suvCarBO;
        case VAN:
            factory = new VanCarAbstractionFactoryImpl();
            VanCarBO vanCarBO = new VanCarBO();
            vanCarBO.setTopSpeed(factory.createEngine());
            vanCarBO.setPrice(factory.createSkeleton());
            return vanCarBO;
        default:
            break;
        }

        throw new IllegalArgumentException("无法匹配到 carType 是 " + carType + " 的工厂");
    }
}
