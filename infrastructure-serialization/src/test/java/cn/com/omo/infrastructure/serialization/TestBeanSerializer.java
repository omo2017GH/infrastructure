package cn.com.omo.infrastructure.serialization;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.serialization.core.AbstractBeanSerializer;

/**
 *
 * @date 2018年1月2日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class TestBeanSerializer extends AbstractBeanSerializer {

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractBeanSerializer#convertStrs2Objs(java.lang.String[])
     */
    @Override
    protected Object[] convertStrs2Objs(String[] fieldValues) {
        int length = fieldValues.length;
        if (length != 4) {
            return null;
        }

        Object[] objs = new  Object[length];
        objs[0] = fieldValues[0];
        objs[1] = fieldValues[1];
        objs[2] = Boolean.parseBoolean(fieldValues[2]);
        objs[3] = new BigDecimal(fieldValues[3]);

        return objs;
    }

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractSerializer#getSplitRegex()
     */
    @Override
    public String getSplitRegex() {
        return "\\|";
    }

}
