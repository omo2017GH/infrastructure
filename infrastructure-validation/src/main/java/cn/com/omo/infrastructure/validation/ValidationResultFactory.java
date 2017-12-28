package cn.com.omo.infrastructure.validation;

import cn.com.omo.infrastructure.validation.core.result.SimpleValidationResult;
import cn.com.omo.infrastructure.validation.core.result.ValidationResult;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class ValidationResultFactory {

    private ValidationResultFactory() {}

    public static ValidationResult getDefaultSuccessResult() {
        return SuccessResultHolder.getInstance();
    }

    public static ValidationResult buildFailureResult(String reason) {
        SimpleValidationResult simpleValidationResult = new SimpleValidationResult();
        simpleValidationResult.setPass(false);
        simpleValidationResult.setReason(reason);

        return simpleValidationResult;
    }
    
    private static class SuccessResultHolder {
        private static SimpleValidationResult instance;

        static SimpleValidationResult getInstance() {
            if (instance == null) {
                instance = new SimpleValidationResult();
                instance.setPass(true);
                instance.setReason("");
            }
            return instance;
        }
    }
}
