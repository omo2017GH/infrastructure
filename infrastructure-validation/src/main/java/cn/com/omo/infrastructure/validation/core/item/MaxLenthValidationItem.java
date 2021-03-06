package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import cn.com.omo.infrastructure.common.util.InstanceUtils;
import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class MaxLenthValidationItem extends BaseBigDecimalValidationItem<Object> {

    public MaxLenthValidationItem(BigDecimal itemValue) {
        super(itemValue);
    }

    public MaxLenthValidationItem(BigDecimal itemValue, boolean includeBound) {
        super(itemValue, includeBound);
    }

    @Override
    protected boolean checkData(Object data) {
        BigDecimal num1 = getItemValue();
        BigDecimal num2 = null;
        if (InstanceUtils.instanceOfCollection(data)) {
            num2 = new BigDecimal(((Collection<?>) data).size());
        } else if (data.getClass().isArray()) {
            List<Object> list = InstanceUtils.getListFromArrayObj(data, Object.class);
            num2 = new BigDecimal(list.size());
        } else if (InstanceUtils.instanceOfString(data)) {
            num2 = new BigDecimal(data.toString().length());
        }

        if (!isIncludeBound()) {
            return BigDecimalUtils.greater(num1, num2);
        } else {
            return BigDecimalUtils.notLess(num1, num2);
        }
    }

}
