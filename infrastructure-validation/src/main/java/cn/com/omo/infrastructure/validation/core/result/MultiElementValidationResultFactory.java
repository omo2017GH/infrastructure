/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.result;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class MultiElementValidationResultFactory {

    private MultiElementValidationResultFactory() {}

    public static MultiElementValidationResult getDefaultSuccessResult() {
        return SuccessResultHolder.getInstance();
    }

    private static class SuccessResultHolder {
        private static SimpleMultiElementValidationResult instance;

        static SimpleMultiElementValidationResult getInstance() {
            if (instance == null) {
                instance = new SimpleMultiElementValidationResult();
                instance.setPass(true);
            }
            return instance;
        }
    }

}
