package cn.com.omo.infrastructure.validation.jsr303.core.item;

import cn.com.omo.infrastructure.validation.core.checker.AbstractValidationItemChecker;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class BaseJvalidationItem<T> extends AbstractValidationItemChecker<Object>implements JvalidationItem {

    public BaseJvalidationItem(T itemValue, String message) {
        setItemValue(itemValue);
        setMessage(message);
    }

    private Class<?>[] supportedTypes;

    private T itemValue;

    private String message;

    /**
     * @see com.huifu.ubs.service.common.model.validation.checker.AbstractValidationItemChecker#checkData(java.lang.Object)
     */
    @Override
    protected boolean checkData(Object data) {
        Class<?> dataType = data.getClass();
        if (!isSupportedType(dataType)) {
            return false;
        }
        return doCheckData(data);
    }

    protected abstract boolean doCheckData(Object data);
    
    protected boolean isSupportedOtherSpecialType(Class<?> dataType) {
        return false;
    }

    private boolean isSupportedType(Class<?> dataType) {
        if (isSupportedOtherSpecialType(dataType)) {
            return true;
        }

        if (supportedTypes == null || supportedTypes.length == 0) {
            return false;
        }

        for (Class<?> type : supportedTypes) {
            if (type.isAssignableFrom(dataType)) {
                return true;
            }
            continue;
        }

        return false;
    }

    public Class<?>[] getSupportedTypes() {
        return supportedTypes;
    }

    public void setSupportedTypes(Class<?>[] supportedTypes) {
        this.supportedTypes = supportedTypes;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.ValidationItem#getItemValue()
     */
    @Override
    public T getItemValue() {
        return itemValue;
    }

    public void setItemValue(T itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.JvalidationItem#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
