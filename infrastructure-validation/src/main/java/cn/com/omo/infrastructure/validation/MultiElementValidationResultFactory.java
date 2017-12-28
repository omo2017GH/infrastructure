package cn.com.omo.infrastructure.validation;

import cn.com.omo.infrastructure.validation.core.result.MultiElementValidationResult;
import cn.com.omo.infrastructure.validation.core.result.SimpleMultiElementValidationResult;

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
