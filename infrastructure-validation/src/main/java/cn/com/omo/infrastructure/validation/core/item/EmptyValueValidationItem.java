/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import cn.com.omo.infrastructure.common.util.InstanceUtils;
import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class EmptyValueValidationItem extends BaseBooleanValidationItem<Object> {

    public EmptyValueValidationItem(Boolean itemValue) {
        super(itemValue);
    }

    @Override
    protected boolean checkData(Object data) {
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = null;

        if (data == null) {
            num2 = num1;
        } else if (InstanceUtils.instanceOfCollection(data)) {
            num2 = new BigDecimal(((Collection<?>) data).size());
        } else if (data.getClass().isArray()) {
            List<Object> list = InstanceUtils.getListFromArrayObj(data, Object.class);
            num2 = new BigDecimal(list.size());
        } else if (InstanceUtils.instanceOfString(data)) {
            num2 = new BigDecimal(data.toString().length());
        }

        if (getItemValue()) {
            return BigDecimalUtils.equal(num1, num2);
        } else {
            return !BigDecimalUtils.equal(num1, num2);
        }
    }
}
