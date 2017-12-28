/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.math.BigDecimal;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DigitsJvalidationItem extends BaseDecimalJvalidationItem {

    public DigitsJvalidationItem(BigDecimal itemValue, String message) {
        super(itemValue, true, message);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.BaseJvalidationItem#doCheckData(java.lang.Object)
     */
    @Override
    protected boolean doCheckData(Object data) {
        if (!super.doCheckData(data)) {
            return false;
        }

        String dataDigitsStr = data.toString();
        BigDecimal dataDigits = new BigDecimal(dataDigitsStr);
        BigDecimal dataDigitsInteger = dataDigits.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal dataDigitsFraction = dataDigits.subtract(dataDigitsInteger);

        BigDecimal itemValue = getItemValue();
        BigDecimal itemValueInteger = itemValue.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal itemValueFraction = itemValue.subtract(itemValueInteger);

        boolean c1 = (dataDigitsInteger.compareTo(itemValueInteger) <= 0);
        boolean c2 = (dataDigitsFraction.compareTo(itemValueFraction) <= 0);

        return (c1 && c2);
    }
}
