/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import cn.com.omo.infrastructure.common.util.InstanceUtils;

/**
 * 布尔值校验项，data可以是布尔值也可以是String，若为String，当data="true"或"t"时（不区分大小写）代表布尔值true
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class BooleanValueValidationItem extends BaseBooleanValidationItem<Object> {

    private static final String TRUE = "true";
    private static final String T = "t";

    public BooleanValueValidationItem(Boolean itemValue) {
        super(itemValue);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.checker.AbstractValidationItemChecker#checkData(java.lang.Object)
     */
    @Override
    protected boolean checkData(Object data) {
        Boolean itemValue = getItemValue();
        Boolean dataBoolean = null;
        if (InstanceUtils.instanceOfString(data)) {
            if (TRUE.equalsIgnoreCase(data.toString()) || T.equalsIgnoreCase(data.toString())) {
                dataBoolean = Boolean.TRUE;
            }
        } else if (InstanceUtils.instanceOfBoolean(data)) {
            dataBoolean = (Boolean) data;
        }
        if (dataBoolean == null) {
            return false;
        } else {
            return itemValue.booleanValue() == dataBoolean.booleanValue();
        }
    }
}
