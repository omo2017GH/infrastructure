/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.serialization.exception;

import cn.com.omo.infrastructure.common.model.exception.InfrastructureException;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DeserializationException extends InfrastructureException {

    /**
     * 
     */
    private static final long serialVersionUID = 4437027182117706144L;

    public DeserializationException(String message) {
        super(message);
    }

    public DeserializationException(String message, Throwable t) {
        super(message, t);
    }
}
