/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core;

import cn.com.omo.infrastructure.validation.core.result.MultiElementValidationResult;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface MultiElementValidator {

    void addValidationTarget(ValidationTarget<?> validationTarget);

    MultiElementValidationResult vaildateAll();
}
