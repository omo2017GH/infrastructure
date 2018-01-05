package cn.com.omo.infrastructure.serialization.core;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import cn.com.omo.infrastructure.common.util.ReflectionUtils;
import cn.com.omo.infrastructure.serialization.anno.SeriesInfo;
import cn.com.omo.infrastructure.serialization.exception.DeserializationException;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractBeanSerializer extends AbstractSerializer {

    private static final FieldComparator FC = new FieldComparator();

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractSerializer#bean2List(java.lang.Object)
     */
    @Override
    protected List<String> bean2List(Object bean) {
        if (bean == null) {
            return null;
        }

        Field[] declaredFields = sortAndGetFields(bean);
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }

        List<String> beanFieldValues = new LinkedList<String>();
        for (Field declaredField : declaredFields) {
            Object fieldValue = ReflectionUtils.getFieldValue(bean, declaredField);
            if (fieldValue == null) {
                continue;
            }

            beanFieldValues.add(fieldValue.toString());
        }

        return beanFieldValues;
    }

    /**
     * @see cn.com.omo.infrastructure.serialization.core.AbstractSerializer#initializeBean(java.lang.String[],
     *      java.lang.Object)
     */
    @Override
    protected void initializeBean(String[] fieldValues, Object newInstance) {
        int length = fieldValues.length;
        Field[] declaredFields = sortAndGetFields(newInstance);
        if (declaredFields.length != length) {
            throw new DeserializationException("反序列化对象异常：字段个数与序列元素个数不同");
        }

        Object[] objs = convertStrs2Objs(fieldValues, declaredFields);
        if (objs.length != length) {
            throw new DeserializationException("反序列化对象异常：字符串转对象异常");
        }

        int objIndex = 0;
        for (Field declaredField : declaredFields) {
            try {
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                declaredField.set(newInstance, objs[objIndex++]);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new DeserializationException("反序列化对象异常", e);
            }
        }
    }

    /**
     * 将分割后的序列，转化成bean的属性
     * @param fieldValues
     * @return
     */
    protected abstract Object[] convertStrs2Objs(String[] fieldValues, Field[] declaredFields);

    private Field[] sortAndGetFields(Object obj) {
        Field[] declaredFields = ReflectionUtils.getPrivateDeclaredFields(obj.getClass());
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        } else if (declaredFields.length > 1) {
            Arrays.sort(declaredFields, FC);
        }

        return declaredFields;
    }

    private static class FieldComparator implements Comparator<Field> {

        @Override
        public int compare(Field f1, Field f2) {
            int pos1 = getPos(f1);
            int pos2 = getPos(f2);

            return pos1 - pos2;
        }

        private int getPos(Field f) {
            SeriesInfo anno = f.getAnnotation(SeriesInfo.class);
            if (anno == null) {
                return Integer.MAX_VALUE;
            } else {
                return anno.pos();
            }
        }
    }
}
