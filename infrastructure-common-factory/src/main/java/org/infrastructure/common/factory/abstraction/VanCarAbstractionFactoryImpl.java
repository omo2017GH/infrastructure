/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory.abstraction;

import java.math.BigDecimal;

/**
 * VAN 汽车流水线
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class VanCarAbstractionFactoryImpl implements CarAbstractionFactory {

    /* (non-Javadoc)
     * @see org.infrastructure.common.factory.abstraction.CarAbstractionFactory#createEngine()
     */
    @Override
    public Integer createEngine() {
        return Integer.valueOf("180");
    }

    /* (non-Javadoc)
     * @see org.infrastructure.common.factory.abstraction.CarAbstractionFactory#createSkeleton()
     */
    @Override
    public BigDecimal createSkeleton() {
        return new BigDecimal("500000");
    }

}
