/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DecimalMinJvalidationItem extends BaseDecimalJvalidationItem {

    public DecimalMinJvalidationItem(BigDecimal itemValue, boolean inclusive, String message) {
        super(itemValue, inclusive, message);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.BaseJvalidationItem#doCheckData(java.lang.Object)
     */
    @Override
    protected boolean doCheckData(Object data) {
        if (!super.doCheckData(data)) {
            return false;
        }

        BigDecimal num1 = getItemValue();
        BigDecimal num2 = new BigDecimal(data.toString());
        if (isInclusive()) {
            return BigDecimalUtils.notGreater(num1, num2);
        } else {
            return BigDecimalUtils.less(num1, num2);
        }
    }


}
