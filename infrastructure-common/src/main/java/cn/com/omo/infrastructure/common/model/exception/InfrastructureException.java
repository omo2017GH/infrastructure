/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.common.model.exception;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class InfrastructureException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7877821818819956355L;

    public InfrastructureException() {}

    public InfrastructureException(Throwable t) {
        super(t);
    }

    public InfrastructureException(String message) {
        super(message);
    }

    public InfrastructureException(String message, Throwable t) {
        super(message, t);
    }
}
