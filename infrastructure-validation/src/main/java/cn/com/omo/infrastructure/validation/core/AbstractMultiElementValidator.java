package cn.com.omo.infrastructure.validation.core;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.com.omo.infrastructure.validation.MultiElementValidationResultFactory;
import cn.com.omo.infrastructure.validation.core.result.MultiElementValidationResult;
import cn.com.omo.infrastructure.validation.core.result.SimpleMultiElementValidationResult;
import cn.com.omo.infrastructure.validation.core.result.ValidationResult;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractMultiElementValidator extends AbstractValidator implements MultiElementValidator {

    public AbstractMultiElementValidator() {
        super();
        init();
    }

    private List<ValidationTarget<?>> validationTargets;

    /**
     * @see com.huifu.ubs.service.common.model.validation.MultiElementValidator#addValidationTarget(com.huifu.ubs.service.common.model.validation.target.ValidationTarget)
     */
    @Override
    public void addValidationTarget(ValidationTarget<?> validationTarget) {
        if (validationTarget == null) {
            return;
        }

        if (validationTargets == null) {
            init();
        }
        validationTargets.add(validationTarget);
    }

    @Override
    public MultiElementValidationResult vaildateAll() {
        if (validationTargets == null || validationTargets.isEmpty()) {
            return MultiElementValidationResultFactory.getDefaultSuccessResult();
        }

        List<String> illegalReports = new LinkedList<String>();
        SimpleMultiElementValidationResult result = new SimpleMultiElementValidationResult();
        for (ValidationTarget<?> validationTarget : validationTargets) {
            ValidationResult singleResult = vaildate(validationTarget);
            if (!singleResult.isPass()) {
                result.addIllegalElement(validationTarget.getTargetName(), JSON.toJSONString(validationTarget.getTarget()));
                illegalReports.add(singleResult.getReason());
                if (result.isPass()) {
                    result.setPass(false);
                }
            }
        }

        processAfterValidation();

        return result;
    }

    private void init() {
        validationTargets = new LinkedList<ValidationTarget<?>>();
    }

    private void processAfterValidation() {
        init();
    }
}
