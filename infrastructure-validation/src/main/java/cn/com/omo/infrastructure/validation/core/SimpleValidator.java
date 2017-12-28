/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.common.constant.CommonConstants;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.result.ValidationReportor;
import cn.com.omo.infrastructure.validation.core.result.ValidationResult;
import cn.com.omo.infrastructure.validation.core.target.SimpleValidationTarget;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年12月6日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class SimpleValidator extends AbstractValidator {
    
    public SimpleValidator() {
        super();
        init();
    }

    private static final ThreadLocal<SimpleValidationTarget> LOCAL_VALIDATION_TARGET = new ThreadLocal<SimpleValidationTarget>();

    private static final ThreadLocal<StringBuilder> LOCAL_STRING_BUILDER = new ThreadLocal<StringBuilder>();

    public boolean validateRequiredObj(Object field, String fieldName, List<ValidationItem> validationItems) {
        return validateObj(field, fieldName, true, validationItems);
    }

    public boolean validateNotRequiredObj(Object field, String fieldName, List<ValidationItem> validationItems) {
        if (field != null && (field instanceof String) && StringUtils.isEmpty((String) field)) {
            field = null;
        }
        return validateObj(field, fieldName, false, validationItems);
    }

    public String finishValidationAndReportIllegalValues() {
        StringBuilder stringBuilder = LOCAL_STRING_BUILDER.get();

        if (stringBuilder == null) {
            init();
            return null;
        }
        String report = stringBuilder.substring(0, stringBuilder.length() - 1);

        init();

        return report;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.AbstractValidator#reportIllegalValue(com.huifu.ubs.service.common.model.validation.target.ValidationTarget, com.huifu.ubs.service.common.model.validation.item.ValidationItem)
     */
    @Override
    protected <T> String reportIllegalValue(ValidationTarget<T> validationTarget, ValidationItem item) {
        return ValidationReportor.reportAsCommonStyle(validationTarget);
    }
    
    private boolean validateObj(Object field, String fieldName, boolean required, List<ValidationItem> validationItems) {
        SimpleValidationTarget validationTarget = getLocalValidationTarget();
        validationTarget.setTarget(field);
        validationTarget.setTargetName(fieldName);
        validationTarget.setRequired(required);
        validationTarget.setValidationItems(validationItems);
        ValidationResult validationResult = vaildate(validationTarget);

        if (validationResult.isPass()) {
            return true;
        } else {
            addReport(validationResult.getReason());
            return false;
        }
    }

    private void init() {
        LOCAL_VALIDATION_TARGET.remove();
        LOCAL_STRING_BUILDER.remove();
    }

    private void addReport(String reason) {
        StringBuilder stringBuilder = LOCAL_STRING_BUILDER.get();
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            LOCAL_STRING_BUILDER.set(stringBuilder);
        }
        stringBuilder.append(reason).append(CommonConstants.COMMA);
    }

    private SimpleValidationTarget getLocalValidationTarget() {
        SimpleValidationTarget simpleValidationTarget = LOCAL_VALIDATION_TARGET.get();
        if (simpleValidationTarget == null) {
            simpleValidationTarget = new SimpleValidationTarget();
            LOCAL_VALIDATION_TARGET.set(simpleValidationTarget);
        }
        return simpleValidationTarget;
    }
}
