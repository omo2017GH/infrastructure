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
public abstract class BaseBooleanValidationItem<T> extends AbstractValidationItemChecker<T> {

    private Boolean itemValue;

    public BaseBooleanValidationItem(Boolean itemValue) {
        setItemValue(itemValue);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.ValidationItem#getItemValue()
     */
    @Override
    public Boolean getItemValue() {
        return itemValue;
    }

    public void setItemValue(Boolean itemValue) {
        this.itemValue = itemValue;
    }
}
