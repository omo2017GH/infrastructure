package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.common.util.InstanceUtils;
import cn.com.omo.infrastructure.common.util.number.BigDecimalUtils;
import cn.com.omo.infrastructure.common.util.number.NumberFormatterUtils;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class InequivalenceValidationItem extends BaseObjectValidationItem<Object> {

    public InequivalenceValidationItem(Object itemValue) {
        super(itemValue);
    }

    @Override
    protected boolean checkData(Object data) {
        Object itemValue = getItemValue();
        if (InstanceUtils.instanceOfNumber(itemValue)) {
            BigDecimal num1 = NumberFormatterUtils.parseNumber(itemValue.toString());
            BigDecimal num2 = NumberFormatterUtils.parseNumber(data.toString());
            return !BigDecimalUtils.equal(num1, num2);
        }
        if (InstanceUtils.instanceOfString(itemValue)) {
            return !itemValue.toString().equals(data.toString());
        }
        return true;
    }

}
