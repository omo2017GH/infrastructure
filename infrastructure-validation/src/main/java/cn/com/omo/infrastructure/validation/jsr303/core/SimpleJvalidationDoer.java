/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import cn.com.omo.infrastructure.validation.ValidationResultFactory;
import cn.com.omo.infrastructure.validation.core.AbstractMultiElementValidator;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.result.MultiElementValidationResult;
import cn.com.omo.infrastructure.validation.core.result.ValidationResult;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;
import cn.com.omo.infrastructure.validation.jsr303.core.item.JvalidationItem;
import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;
import cn.com.omo.infrastructure.validation.jsr303.core.result.SimpleJvalidationResult;
import cn.com.omo.infrastructure.validation.jsr303.core.target.JvalidationTarget;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
@Component("SimpleJvalidationDoer")
public class SimpleJvalidationDoer extends AbstractMultiElementValidator {

    public SimpleJvalidationDoer() {
        super();
        init();
    }

    private Map<String, ValidationResult> jvalidationTargetsMap;
    private Map<String, AtomicInteger> targetNameNoMap;

    private static final String DEFAULT_NAME = "defaultName";
    private static final String DEFAULT_MESSAGE = "Illegal Value";

    /**
     * @see com.huifu.ubs.service.common.model.validation.AbstractValidator#vaildate(com.huifu.ubs.service.common.model.validation.target.ValidationTarget)
     */
    @Override
    public <T> ValidationResult vaildate(ValidationTarget<T> validationTarget) {
        if (!(validationTarget instanceof JvalidationTarget)) {
            return ValidationResultFactory.getDefaultSuccessResult();
        }

        ValidationResult validationResult = super.vaildate(validationTarget);
        addValidationResultIntoMap(validationTarget, validationResult);
        return validationResult;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.AbstractMultiElementValidator#vaildateAll()
     */
    @Override
    public MultiElementValidationResult vaildateAll() {
        MultiElementValidationResult meResult = super.vaildateAll();
        JvalidationResult jresult = convertResult(meResult);
        processAfterValidation();
        return jresult;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.AbstractMultiElementValidator#addValidationTarget(com.huifu.ubs.service.common.model.validation.target.ValidationTarget)
     */
    @Override
    public void addValidationTarget(ValidationTarget<?> validationTarget) {
        if (!(validationTarget instanceof JvalidationTarget)) {
            return;
        }
        super.addValidationTarget(validationTarget);
    }

    @Override
    protected <T> String reportIllegalValue(ValidationTarget<T> validationTarget, ValidationItem item) {
        return ((JvalidationItem) item).getMessage();
    }

    protected JvalidationResult convertResult(MultiElementValidationResult meResult) {
        SimpleJvalidationResult jresult = new SimpleJvalidationResult();
        boolean pass = meResult.isPass();
        jresult.setPass(pass);
        if (pass) {
            return jresult;
        }

        Map<String, String> illegalElements = meResult.getIllegalElements();
        if (illegalElements == null || illegalElements.isEmpty()) {
            return jresult;
        }

        for (Entry<String, String> entry : illegalElements.entrySet()) {
            String targetName = entry.getKey();
            ValidationResult validationResult = jvalidationTargetsMap.get(targetName);
            if (validationResult == null) {
                jresult.addIllegalElementMessage(targetName, DEFAULT_MESSAGE);
            } else {
                String message = validationResult.getReason();
                jresult.addIllegalElementMessage(targetName, message);
            }
            jresult.addIllegalElement(targetName, entry.getValue());
        }

        return jresult;
    }

    private void init() {
        int initialCapacity = 50;
        jvalidationTargetsMap = new HashMap<String, ValidationResult>(initialCapacity);
        targetNameNoMap = new HashMap<String, AtomicInteger>(initialCapacity);
    }

    private void processAfterValidation() {
        init();
    }

    private void addValidationResultIntoMap(ValidationTarget<?> validationTarget, ValidationResult validationResult) {
        if (validationTarget == null) {
            return;
        }

        Object target = validationTarget.getTarget();
        String name = DEFAULT_NAME;
        if (target != null) {
            name = target.getClass().getSimpleName();
        }

        String targetName = validationTarget.getTargetName();
        if (StringUtils.isBlank(targetName)) {
            targetName = getTargetNameWithNum(name, 0);
        }

        // 字段名重名处理
        if (jvalidationTargetsMap.get(targetName) != null) {
            targetName = getTargetNameWithNum(targetName, 1);
        }

        jvalidationTargetsMap.put(targetName, validationResult);
    }

    private String getTargetNameWithNum(String targetName, int initialValue) {
        AtomicInteger targetNameNo = targetNameNoMap.get(targetName);
        if (targetNameNo == null) {
            targetNameNo = new AtomicInteger(initialValue);
            targetNameNoMap.put(targetName, targetNameNo);
        }

        return targetName = targetName + "#" + targetNameNo.getAndIncrement();
    }
}
