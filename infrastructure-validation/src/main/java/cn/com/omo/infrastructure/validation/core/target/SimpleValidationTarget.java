package cn.com.omo.infrastructure.validation.core.target;

import java.util.List;

import cn.com.omo.infrastructure.validation.core.item.ValidationItem;

/**
 *
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleValidationTarget implements ValidationTarget<Object> {

    public SimpleValidationTarget() {}

    public SimpleValidationTarget(Object target, String targetName, List<ValidationItem> validationItems) {
        this(target, targetName, true, validationItems);
    }

    public SimpleValidationTarget(Object target, String targetName, boolean required, List<ValidationItem> validationItems) {
        setTarget(target);
        setTargetName(targetName);
        setValidationItems(validationItems);
        setRequired(required);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -8562756683862664510L;

    private Object target;
    
    private String targetName;

    private boolean required;

    private List<ValidationItem> validationItems;

    /**
     * @see com.huifu.ubs.service.common.model.validation.target.ValidationTarget#getTarget()
     */
    @Override
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.target.ValidationTarget#getTargetName()
     */
    @Override
    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.target.ValidationTarget#isRequired()
     */
    @Override
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.target.ValidationTarget#getValidationItems()
     */
    @Override
    public List<ValidationItem> getValidationItems() {
        return validationItems;
    }

    public void setValidationItems(List<ValidationItem> validationItems) {
        this.validationItems = validationItems;
    }
}
