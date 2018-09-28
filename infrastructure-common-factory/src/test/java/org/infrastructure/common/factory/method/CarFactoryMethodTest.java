/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.method;

import org.infrastructure.common.factory.CarBO;
import org.infrastructure.common.factory.CarTypeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 工厂方法测试类
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class CarFactoryMethodTest {

    @Test
    public void test() {
        CarFactoryMethod factory = CarFactoryRouter.getFactory(CarTypeEnum.VAN);
        CarBO van = factory.createCar();
        Assert.assertEquals(van.getTopSpeed(), Integer.valueOf("180"));
    }
}
