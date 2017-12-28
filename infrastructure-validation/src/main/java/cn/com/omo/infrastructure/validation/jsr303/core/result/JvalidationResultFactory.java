package cn.com.omo.infrastructure.validation.jsr303.core.result;

import java.util.Map;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class JvalidationResultFactory {

    private JvalidationResultFactory() {}

    public static JvalidationResult getDefaultSuccessResult() {
        return SuccessResultHolder.getInstance();
    }

    public static JvalidationResult buildFailureResult(Map<String, String> illegalElements, Map<String, String> illegalElementMessages) {
        SimpleJvalidationResult simpleValidationResult = new SimpleJvalidationResult(false);
        simpleValidationResult.setIllegalElements(illegalElements);
        simpleValidationResult.setIllegalElementMessages(illegalElementMessages);

        return simpleValidationResult;
    }
    
    private static class SuccessResultHolder {
        private static SimpleJvalidationResult instance;

        static JvalidationResult getInstance() {
            if (instance == null) {
                instance = new SimpleJvalidationResult(true);
            }
            return instance;
        }
    }
}
