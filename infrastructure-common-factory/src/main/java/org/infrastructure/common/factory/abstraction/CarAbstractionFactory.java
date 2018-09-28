/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.abstraction;

import java.math.BigDecimal;

/**
 * 抽象工厂接口示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface CarAbstractionFactory {

    /**
     * 制造引擎（决定汽车的速度）
     * @return 汽车的最高时速
     */
    Integer createEngine();

    /**
     * 制造车架（决定汽车的价格）
     * @return 车价
     */
    BigDecimal createSkeleton();
}
