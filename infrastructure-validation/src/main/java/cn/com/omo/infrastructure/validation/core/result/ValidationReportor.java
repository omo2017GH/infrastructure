/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.result;

import com.alibaba.fastjson.JSON;

import cn.com.omo.infrastructure.common.constant.CommonConstants;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class ValidationReportor {

    public static <T> String reportAsCommonStyle(ValidationTarget<T> validationTarget) {
        StringBuilder reason = new StringBuilder();
        reason.append(validationTarget.getTargetName()).append("(value=")
                .append(JSON.toJSONString(validationTarget.getTarget())).append(")");

        return reason.toString().replace(CommonConstants.DOUBLE_QUOTE, CommonConstants.EMPTY_STR)
                .replace(CommonConstants.BACK_SLASH, CommonConstants.EMPTY_STR);
    }
}
