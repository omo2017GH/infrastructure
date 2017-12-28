/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import cn.com.omo.infrastructure.common.util.InstanceUtils;
import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;

/**
 * 枚举值校验项：校验data存在或不存在指定的枚举值范畴中，枚举值范畴itemValue可以是
 * List或String[]，被校验值data可以是String或者Number
 * 
 * @date 2017年12月6日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class EnumValidationItem extends BaseObjectValidationItem<Object> {

    /**
     * 被校验值存在或不存在指定的枚举值范畴中
     */
    private boolean in;

    public EnumValidationItem(Object itemValue, boolean in) {
        super(itemValue);
        setIn(in);
    }

    @Override
    protected boolean checkData(Object data) {
        Object itemValue = getItemValue();
        if (!InstanceUtils.instanceOfCollection(itemValue) && !itemValue.getClass().isArray()) {
            return true;
        }

        if (InstanceUtils.instanceOfCollection(itemValue)) {
            Collection<?> collection = (Collection<?>) itemValue;
            return doCollectionValidate(collection, data);
        } else {
            List<Object> list = InstanceUtils.getListFromArrayObj(itemValue, Object.class);
            return doCollectionValidate(list, data);
        }
    }

    private boolean doCollectionValidate(Collection<?> c, Object data) {
        if (c.isEmpty()) {
            return true;
        }
        if (!InstanceUtils.instanceOfString(c.iterator().next())) {
            return true;
        }

        if (isIn()) {
            if (InstanceUtils.instanceOfNumber(data)) {
                BigDecimal num1 = new BigDecimal(data.toString());
                Iterator<?> iterator = c.iterator();
                for (; iterator.hasNext();) {
                    BigDecimal num2 = new BigDecimal(iterator.next().toString());
                    if (BigDecimalUtils.equal(num1, num2)) {
                        return true;
                    }
                }
                return false;
            } else {
                return c.contains(data);
            }
        } else {
            if (InstanceUtils.instanceOfNumber(data)) {
                BigDecimal num1 = new BigDecimal(data.toString());
                Iterator<?> iterator = c.iterator();
                for (; iterator.hasNext();) {
                    BigDecimal num2 = new BigDecimal(iterator.next().toString());
                    if (BigDecimalUtils.equal(num1, num2)) {
                        return false;
                    }
                }
                return true;
            } else {
                return !c.contains(data);
            }
        }
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

}
