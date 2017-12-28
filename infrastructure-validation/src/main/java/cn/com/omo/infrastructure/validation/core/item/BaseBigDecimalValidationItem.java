/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.validation.core.checker.AbstractValidationItemChecker;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class BaseBigDecimalValidationItem<T> extends AbstractValidationItemChecker<T> implements NumberValidationItem {

    private BigDecimal itemValue;

    private boolean includeBound;


    public BaseBigDecimalValidationItem(BigDecimal itemValue) {
        this(itemValue, true);
    }

    public BaseBigDecimalValidationItem(BigDecimal itemValue, boolean includeBound) {
        setItemValue(itemValue);
        setIncludeBound(includeBound);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.ValidationItem#getItemValue()
     */
    @Override
    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.NumberValidationItem#isIncludeBound()
     */
    @Override
    public boolean isIncludeBound() {
        return includeBound;
    }

    public void setIncludeBound(boolean includeBound) {
        this.includeBound = includeBound;
    }
}
