/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core;

import java.util.List;

import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.result.ValidationReportor;
import cn.com.omo.infrastructure.validation.core.target.SimpleValidationTarget;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleMultiElementValidator extends AbstractMultiElementValidator {

    public void addRequiredValidationElement(Object field, String fieldName, List<ValidationItem> validationItems) {
        addValidationElement(field, fieldName, true, validationItems);
    }
    
    public void addValidationElement(Object field, String fieldName, boolean required, List<ValidationItem> validationItems) {
        SimpleValidationTarget validationTarget = new SimpleValidationTarget(field, fieldName, required, validationItems);
        addValidationTarget(validationTarget);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.AbstractValidator#reportIllegalValue(com.huifu.ubs.service.common.model.validation.target.ValidationTarget, com.huifu.ubs.service.common.model.validation.item.ValidationItem)
     */
    @Override
    protected <T> String reportIllegalValue(ValidationTarget<T> validationTarget, ValidationItem item) {
        return ValidationReportor.reportAsCommonStyle(validationTarget);
    }
}
