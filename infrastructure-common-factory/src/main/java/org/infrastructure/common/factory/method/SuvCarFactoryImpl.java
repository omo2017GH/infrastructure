/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.method;

import org.infrastructure.common.factory.CarBO;
import org.infrastructure.common.factory.SuvCarBO;

/**
 * 制造SUV的车工厂示例
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class SuvCarFactoryImpl implements CarFactoryMethod {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.infrastructure.common.factory.method.CarFactoryMethod#createCar()
     */
    @Override
    public CarBO createCar() {
        return new SuvCarBO();
    }

}
