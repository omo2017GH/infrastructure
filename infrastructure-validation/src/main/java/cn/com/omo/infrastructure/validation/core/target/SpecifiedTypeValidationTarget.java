package cn.com.omo.infrastructure.validation.core.target;

import java.util.List;

import cn.com.omo.infrastructure.validation.core.item.ValidationItem;

/**
 *
 * @date 2017年11月30日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class SpecifiedTypeValidationTarget extends SimpleValidationTarget {

    public SpecifiedTypeValidationTarget(Object target, String targetName, List<ValidationItem> validationItems,
            Class<?> type) {
        this(target, targetName, true, validationItems, type);
    }

    public SpecifiedTypeValidationTarget(Object target, String targetName, boolean required,
            List<ValidationItem> validationItems, Class<?> type) {
        super(target, targetName, required, validationItems);
        this.type = type;
    }

    /**
     * 
     */
    private static final long serialVersionUID = -2261948418413045511L;

    private Class<?> type;

    public Class<?> getType() {
        return type;
    }
}
