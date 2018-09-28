/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.factory;

import java.math.BigDecimal;

/**
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class VanCarBO extends BaseCarBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2883422541959495920L;

    private Integer topSpeed = Integer.valueOf("180");
    private BigDecimal price = new BigDecimal("500000");

    /*
     * (non-Javadoc)
     * 
     * @see org.infrastructure.common.factory.Car#getTopSpeed()
     */
    @Override
    public Integer getTopSpeed() {
        return topSpeed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.infrastructure.common.factory.CarBO#getPrice()
     */
    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setTopSpeed(Integer topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
