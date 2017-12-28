/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core;

import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;

/**
 *
 * @date 2017年12月13日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface Jvalidator {

    JvalidationResult validate(Object pojo);
}
