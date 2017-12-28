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
public abstract class BaseObjectValidationItem<T> extends AbstractValidationItemChecker<T> {

    private Object itemValue;

    public BaseObjectValidationItem(Object itemValue) {
        setItemValue(itemValue);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.ValidationItem#getItemValue()
     */
    @Override
    public Object getItemValue() {
        return itemValue;
    }

    public void setItemValue(Object itemValue) {
        this.itemValue = itemValue;
    }
}
