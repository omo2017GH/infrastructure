package cn.com.omo.infrastructure.serialization.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.springframework.beans.BeanUtils;

import cn.com.omo.infrastructure.common.constant.CommonConstants;
import cn.com.omo.infrastructure.common.util.ReflectionUtils;
import cn.com.omo.infrastructure.serialization.exception.DeserializationException;

/**
 *
 * @date 2018年1月4日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SimpleBeanSerializer extends AbstractBeanSerializer {

    private String splitRegex = CommonConstants.COMMA;

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractBeanSerializer#convertStrs2Objs(java.lang.String[], java.lang.reflect.Field[])
     */
    @Override
    protected Object[] convertStrs2Objs(String[] fieldValues, Field[] declaredFields) {
        int length = fieldValues.length;
        Object[] objs = new Object[length];

        for (int i = 0; i < length; i++) {
            String fieldValue = fieldValues[i];
            Field field = declaredFields[i];
            Class<?> fieldType = field.getType();
            Class<?> fieldWrappedType = ReflectionUtils.convertPrimitive2Wrapper(fieldType);
            Constructor<?> declaredConstructor = ReflectionUtils.getDeclaredConstructor(fieldType, String.class);
            if (declaredConstructor == null && fieldWrappedType == null) {
                throw new DeserializationException(String.format("反序列化对象异常：字段[name=%s, type=%s]不支持属性的自动转化", field.getName(), fieldType));
            } else if (declaredConstructor == null && fieldWrappedType != null) {
                declaredConstructor = ReflectionUtils.getDeclaredConstructor(fieldWrappedType, String.class);
            }

            objs[i] =  BeanUtils.instantiateClass(declaredConstructor, fieldValue);
        }

        return objs;
    }

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractSerializer#getSplitRegex()
     */
    @Override
    public String getSplitRegex() {
        return splitRegex;
    }

    public void setSplitRegex(String splitRegex) {
        if (splitRegex == null) {
            return;
        }

        this.splitRegex = splitRegex;
    }

}
