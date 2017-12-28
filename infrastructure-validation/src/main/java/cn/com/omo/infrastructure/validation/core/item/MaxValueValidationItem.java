/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;
import cn.com.omo.infrastructure.common.util.number.NumberFormatterUtils;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class MaxValueValidationItem extends BaseBigDecimalValidationItem<Object> {

    public MaxValueValidationItem(BigDecimal itemValue) {
        super(itemValue);
    }

    public MaxValueValidationItem(BigDecimal itemValue, boolean includeBound) {
        super(itemValue, includeBound);
    }

    @Override
    protected boolean checkData(Object data) {
        BigDecimal num1 = getItemValue();
        BigDecimal num2 = NumberFormatterUtils.parseNumber(data.toString());
        if (!isIncludeBound()) {
            return BigDecimalUtils.greater(num1, num2);
        } else {
            return BigDecimalUtils.notLess(num1, num2);
        }
    }

}
