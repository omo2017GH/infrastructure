/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.simple;

import org.infrastructure.common.factory.CarBO;
import org.infrastructure.common.factory.CarTypeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 简单工厂测试类
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class CarSimpleFactoryTest {

    @Test
    public void test() {
        CarBO suv = CarSimpleFactory.createCar(CarTypeEnum.SUV);
        Assert.assertEquals(suv.getTopSpeed(), Integer.valueOf("260"));
    }
}
