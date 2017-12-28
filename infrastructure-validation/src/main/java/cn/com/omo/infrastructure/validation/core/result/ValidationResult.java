/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.result;

import java.io.Serializable;

/**
 * 校验结果对象
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ValidationResult extends Serializable {

    /**
     * 校验是否通过
     */
    boolean isPass();

    /**
     * 校验未通过原因
     */
    String getReason();
}
