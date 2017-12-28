/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class BlankValueValidationItem extends BaseBooleanValidationItem<String> {

    public BlankValueValidationItem(Boolean itemValue) {
        super(itemValue);
    }

    @Override
    protected boolean checkData(String data) {
        if (getItemValue()) {
            return StringUtils.isBlank(data);
        } else {
            return StringUtils.isNotBlank(data);
        }
    }

}
