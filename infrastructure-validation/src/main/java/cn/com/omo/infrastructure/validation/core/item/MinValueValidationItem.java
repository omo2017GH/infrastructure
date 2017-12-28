package cn.com.omo.infrastructure.validation.core.item;

import java.math.BigDecimal;

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
public class MinValueValidationItem extends BaseBigDecimalValidationItem<Object> {
    public MinValueValidationItem(BigDecimal itemValue) {
        super(itemValue);
    }

    public MinValueValidationItem(BigDecimal itemValue, boolean includeBound) {
        super(itemValue, includeBound);
    }

    @Override
    protected boolean checkData(Object data) {
        BigDecimal num1 = getItemValue();
        BigDecimal num2 = NumberFormatterUtils.parseNumber(data.toString());
        if (!isIncludeBound()) {
            return BigDecimalUtils.less(num1, num2);
        } else {
            return BigDecimalUtils.notGreater(num1, num2);
        }
    }

}
