package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.math.BigDecimal;

/**
 *
 * @date 2017年12月12日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class MinJvalidationItem extends DecimalMinJvalidationItem {

    public MinJvalidationItem(BigDecimal itemValue, String message) {
        super(itemValue, true, message);
    }

    @Override
    protected boolean doCheckData(Object data) {
        Class<?> dataClazz = data.getClass();
        if (CharSequence.class.isAssignableFrom(dataClazz)) {
            return false;
        }
        return super.doCheckData(data);
    }
}
