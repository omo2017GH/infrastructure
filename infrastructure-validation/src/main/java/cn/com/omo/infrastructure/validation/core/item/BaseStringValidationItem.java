/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import cn.com.omo.infrastructure.validation.core.checker.AbstractValidationItemChecker;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class BaseStringValidationItem<T> extends AbstractValidationItemChecker<T> {

    private String itemValue;

    public BaseStringValidationItem(String itemValue) {
        setItemValue(itemValue);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.ValidationItem#getItemValue()
     */
    @Override
    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
