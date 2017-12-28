/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.target;

import java.io.Serializable;
import java.util.List;

import cn.com.omo.infrastructure.validation.core.item.ValidationItem;

/**
 * 校验目标
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ValidationTarget<T> extends Serializable {

    /**
     * 校验对象
     * @return
     */
    T getTarget();

    /**
     * 校验对象名称
     * @return
     */
    String getTargetName();

    /**
     * 是否必输项
     * @return
     */
    boolean isRequired();

    /**
     * 校验项列表
     * @return
     */
    List<ValidationItem> getValidationItems();

}
