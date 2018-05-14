package cn.com.omo.infrastructure.validation.jsr303.core.target;

import java.util.LinkedList;
import java.util.List;

import cn.com.omo.infrastructure.common.util.collection.ListUtils;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;
import cn.com.omo.infrastructure.validation.core.target.SimpleValidationTarget;
import cn.com.omo.infrastructure.validation.jsr303.core.item.JvalidationItem;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleJvalidationTarget extends SimpleValidationTarget implements JvalidationTarget {

    public SimpleJvalidationTarget() {}

    private static final JvalidationItem[] EMPTY_ITEMS = new JvalidationItem[0];

    /**
     * 
     */
    private static final long serialVersionUID = -525144946082435437L;

    @Override
    public JvalidationItem[] getJvalidationItems() {
        List<ValidationItem> validationItems = super.getValidationItems();
        if (validationItems == null) {
            return null;
        } else if (validationItems.isEmpty()) {
            return EMPTY_ITEMS;
        }

        List<JvalidationItem> jvalidationItems = new LinkedList<JvalidationItem>();
        for (ValidationItem item : validationItems) {
            if (!(item instanceof JvalidationItem)) {
                continue;
            }
            jvalidationItems.add((JvalidationItem) item);
        }

        return ListUtils.listToArray(jvalidationItems, JvalidationItem.class);
    }
}
