/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.math.BigDecimal;
import java.math.BigInteger;

import cn.com.omo.infrastructure.common.util.number.NumberFormatterUtils;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class BaseDecimalJvalidationItem extends BaseJvalidationItem<BigDecimal> {

    protected static final Class<?>[] SUPPORTED_TYPE = new Class<?>[] { BigDecimal.class, BigInteger.class,
            CharSequence.class, Byte.class, byte.class, Short.class, short.class, Integer.class, int.class, Long.class,
            long.class };

    private boolean inclusive;

    public BaseDecimalJvalidationItem(BigDecimal itemValue, boolean inclusive, String message) {
        super(itemValue, message);
        setSupportedTypes(SUPPORTED_TYPE);
        this.inclusive = inclusive;
    }

    @Override
    protected boolean doCheckData(Object data) {
        return NumberFormatterUtils.isNumber(data.toString());
    }

    public boolean isInclusive() {
        return inclusive;
    }
}
