package cn.com.omo.infrastructure.validation.core;

import java.util.List;

import cn.com.omo.infrastructure.validation.ValidationResultFactory;
import cn.com.omo.infrastructure.validation.core.checker.ValidationItemChecker;
import cn.com.omo.infrastructure.validation.core.item.BlankValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.CustomizationValidationItem;
import cn.com.omo.infrastructure.validation.core.item.EmptyValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.NullValidationItem;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.result.ValidationResult;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 *
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractValidator implements Validator {

    /**
     * @see com.huifu.ubs.service.common.model.validation.Validator#vaildate(com.huifu.ubs.service.common.model.validation.target.ValidationTarget)
     */
    @Override
    public <T> ValidationResult vaildate(ValidationTarget<T> validationTarget) {
        if (validationTarget == null) {
            return ValidationResultFactory.getDefaultSuccessResult();
        }

        T target = validationTarget.getTarget();

        if (!validationTarget.isRequired() && target == null) {
            return ValidationResultFactory.getDefaultSuccessResult();
        }

        List<ValidationItem> validationItems = validationTarget.getValidationItems();
        if (validationItems == null || validationItems.isEmpty()) {
            return ValidationResultFactory.getDefaultSuccessResult();
        }

        for (ValidationItem item : validationItems) {
            if (isEmptyItem(item)) {
                continue;
            }

            boolean pass = validatItem(item, target);
            if (!pass) {
                String reason = reportIllegalValue(validationTarget, item);
                return ValidationResultFactory.buildFailureResult(reason);
            }
        }

        return ValidationResultFactory.getDefaultSuccessResult();
    }

    private boolean isEmptyItem(ValidationItem item) {
        if (item == null || item.getItemValue() == null) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    protected <T> boolean validatItem(ValidationItem item0, T target) {
        if (!(item0 instanceof ValidationItemChecker)) {
            return true;
        }

        ValidationItemChecker<T> item = (ValidationItemChecker<T>) item0;
        boolean pass = true;

        if ((item instanceof CustomizationValidationItem)
                || (item instanceof NullValidationItem)
                || (item instanceof BlankValueValidationItem)
                || (item instanceof EmptyValueValidationItem)) {
            return item.check(target);
        }

        pass = (target == null);
        if (pass) {
            return pass;
        }

        return item.check(target);
    }

    protected abstract <T> String reportIllegalValue(ValidationTarget<T> validationTarget, ValidationItem item);
}
