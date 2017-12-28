/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import cn.com.omo.infrastructure.common.constant.CommonConstants;
import cn.com.omo.infrastructure.common.util.ReflectionUtils;
import cn.com.omo.infrastructure.common.util.number.NumberFormatterUtils;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;
import cn.com.omo.infrastructure.validation.jsr303.core.item.JvalidationItemFactory;
import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;
import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResultFactory;
import cn.com.omo.infrastructure.validation.jsr303.core.target.SimpleJvalidationTarget;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class JvalidationHelper {

    protected static ValidationTarget<?> createValidationTarget(Field field, Object target) {
        List<ValidationItem> validationItems = generateJvalidationItems(field, target);
        if (validationItems == null || validationItems.isEmpty()) {
            return null;
        }

        SimpleJvalidationTarget jalidationTarget = new SimpleJvalidationTarget();
        jalidationTarget.setTarget(target);
        jalidationTarget.setTargetName(field.getName());
        jalidationTarget.setValidationItems(validationItems);
        jalidationTarget.setRequired(true);

        return jalidationTarget;
    }

    protected static List<ValidationItem> generateJvalidationItems(Field field, Object target) {
        Annotation[] annotations = field.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }

        List<ValidationItem> items = new LinkedList<ValidationItem>();
        for (Annotation anno : annotations) {
            ValidationItem jvalidationItem = generateJvalidationItemByAnnoType(anno);
            if (jvalidationItem == null) {
                continue;
            }

            items.add(jvalidationItem);
        }

        return items;
    }

    protected static ValidationItem generateJvalidationItemByAnnoType(Annotation anno) {
        // AssertFalse
        if (AssertFalse.class.equals(anno.annotationType())) {
            AssertFalse anno1 = (AssertFalse) anno;
            ValidationItem jvalidationItem = JvalidationItemFactory.buildBooleanJvalidationItem(Boolean.FALSE,
                    anno1.message());
            return jvalidationItem;
        }

        // AssertTrue
        if (AssertTrue.class.equals(anno.annotationType())) {
            AssertTrue anno1 = (AssertTrue) anno;
            ValidationItem jvalidationItem = JvalidationItemFactory.buildBooleanJvalidationItem(Boolean.TRUE,
                    anno1.message());
            return jvalidationItem;
        }

        // DecimalMax
        if (DecimalMax.class.equals(anno.annotationType())) {
            DecimalMax anno1 = (DecimalMax) anno;
            boolean number = NumberFormatterUtils.isNumber(anno1.value());
            if (!number) {
                return null;
            }
            BigDecimal itemValue = new BigDecimal(anno1.value());
            boolean inclusive = anno1.inclusive();
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildDecimalMaxJvalidationItem(itemValue, inclusive,
                    message);
            return jvalidationItem;
        }

        // DecimalMin
        if (DecimalMin.class.equals(anno.annotationType())) {
            DecimalMin anno1 = (DecimalMin) anno;
            boolean number = NumberFormatterUtils.isNumber(anno1.value());
            if (!number) {
                return null;
            }
            BigDecimal itemValue = new BigDecimal(anno1.value());
            boolean inclusive = anno1.inclusive();
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildDecimalMinJvalidationItem(itemValue, inclusive,
                    message);
            return jvalidationItem;
        }

        // Digits
        if (Digits.class.equals(anno.annotationType())) {
            Digits anno1 = (Digits) anno;
            String integerStr = String.valueOf(anno1.integer());
            String fractionStr = String.valueOf(anno1.fraction());
            BigDecimal itemValue = new BigDecimal(integerStr.concat(".").concat(fractionStr));
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildDigitsJvalidationItem(itemValue, message);
            return jvalidationItem;
        }

        // Future
        if (Future.class.equals(anno.annotationType())) {
            Future anno1 = (Future) anno;
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildFutureJvalidationItem(message);
            return jvalidationItem;
        }

        // Past
        if (Past.class.equals(anno.annotationType())) {
            Past anno1 = (Past) anno;
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildPastJvalidationItem(message);
            return jvalidationItem;
        }

        // Max
        if (Max.class.equals(anno.annotationType())) {
            Max anno1 = (Max) anno;
            BigDecimal itemValue = new BigDecimal(anno1.value());
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildMaxJvalidationItem(itemValue, message);
            return jvalidationItem;
        }

        // Min
        if (Min.class.equals(anno.annotationType())) {
            Min anno1 = (Min) anno;
            BigDecimal itemValue = new BigDecimal(anno1.value());
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildMinJvalidationItem(itemValue, message);
            return jvalidationItem;
        }

        // Null
        if (Null.class.equals(anno.annotationType())) {
            Null anno1 = (Null) anno;
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildNullOrNotJvalidationItem(Boolean.TRUE,
                    message);
            return jvalidationItem;
        }

        // NotNull
        if (NotNull.class.equals(anno.annotationType())) {
            NotNull anno1 = (NotNull) anno;
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildNullOrNotJvalidationItem(Boolean.FALSE,
                    message);
            return jvalidationItem;
        }

        // Pattern
        if (Pattern.class.equals(anno.annotationType())) {
            Pattern anno1 = (Pattern) anno;
            String itemValue = anno1.regexp();
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildPatternJvalidationItem(itemValue, message);
            return jvalidationItem;
        }

        // Size
        if (Size.class.equals(anno.annotationType())) {
            Size anno1 = (Size) anno;
            String itemValue = anno1.min() + CommonConstants.COMMA + anno1.max();
            String message = anno1.message();
            ValidationItem jvalidationItem = JvalidationItemFactory.buildSizeJvalidationItem(itemValue, message);
            return jvalidationItem;
        }

        return null;
    }

    protected static Object getFieldValue(Object object, Field field) {
        return ReflectionUtils.getFieldValue(object, field);
    }

    protected static Field[] getAllDeclaredFields(Class<?> clazz) {
        Field[] declaredFields = null;
        try {
            declaredFields = ReflectionUtils.getDeclaredFields(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return declaredFields;
    }

    protected static JvalidationResult getDefaultSuccessResult() {
        return JvalidationResultFactory.getDefaultSuccessResult();
    }
}
