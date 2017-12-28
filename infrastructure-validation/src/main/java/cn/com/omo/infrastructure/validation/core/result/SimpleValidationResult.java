/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.result;

/**
 *
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleValidationResult implements ValidationResult {

    /**
     * 
     */
    private static final long serialVersionUID = -7976123359560740321L;

    /**
     * 校验是否通过
     */
    private boolean pass;

    /**
     * 校验未通过原因
     */
    private String reason;

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.ValidationResult#isPass()
     */
    @Override
    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.result.ValidationResult#getReason()
     */
    @Override
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
