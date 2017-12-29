package cn.com.omo.infrastructure.serialization.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.serialization.exception.DeserializationException;
import cn.com.omo.infrastructure.serialization.exception.SerializationException;

/**
 * 非JSON格式的序列化（根据splitRegex分割字段值）
 * @date 2017年12月28日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class AbstractSerializer implements Serializer {

    /**
     * @see cn.com.omo.infrastructure.serialization.core.Serializer#serialize(java.lang.Object)
     */
    @Override
    public String serialize(Object bean) {
        if (bean == null) {
            return null;
        }

        String splitRegex = getSplitRegex();
        if (StringUtils.isBlank(splitRegex)) {
            throw new SerializationException("序列化对象异常：无效的分隔符");
        }

        List<String> fieldValues = bean2List(bean);
        if (fieldValues == null || fieldValues.isEmpty()) {
            throw new SerializationException("序列化对象异常");
        }

        StringBuffer sbf = new StringBuffer();
        for (String fieldValue : fieldValues) {
            sbf.append(fieldValue).append(splitRegex);
        }

        return sbf.substring(0, sbf.length() - 1);
    }

    /**
     * @see cn.com.omo.infrastructure.serialization.core.Serializer#deserialize(java.lang.String, java.lang.Class)
     */
    @Override
    public <T> T deserialize(String series, Class<T> clazz) {
        if (StringUtils.isBlank(series) || clazz == null) {
            return null;
        }

        try {
            T newInstance = clazz.newInstance();

            String[] fieldValues = series.split(getSplitRegex());
            if (fieldValues == null || fieldValues.length == 0) {
                throw new DeserializationException("反序列化对象异常：无效的序列");
            }

            initializeBean(fieldValues, newInstance);
            return newInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DeserializationException("反序列化对象异常", e);
        }
    }

    public abstract String getSplitRegex();

    protected abstract List<String> bean2List(Object bean);

    protected abstract void initializeBean(String[] fieldValues, Object newInstance);
}
