/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package cn.com.omo.infrastructure.common.util.conversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 * <h3>bean转换模板类</h3>
 * <p>
 * 将来源bean S类型 转化为 目标bean T类型
 * 
 * @date 2018年3月20日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class ConversionTemplate<S, T> {

    /**
     * <ol>
     * <li>Creates a new target instance of the class represented by this target
     * Class object using its no-arg constructor.
     * <li>Copy the property values of the given source bean into the target
     * instance.
     * <li>Convert the property values of the given source bean into the target
     * instance using special convertor.
     * </ol>
     * 
     * @param source the source bean
     * @param targetClazz the class represented by this target Class object
     * 
     * @throws BeanInstantiationException if the bean cannot be instantiated
     * @throws BeansException if the copying failed
     * 
     * @return the new instance of the class represented by this target Class
     *         object
     * 
     * @see BeanUtils#instantiate(Class)
     * @see BeanUtils#copyProperties(Object, Object)
     * @see BiConsumer
     */
    public T convertGenericType(S source, Class<T> targetClazz, BiConsumer<S, T> convertor) {
        if (source == null || targetClazz == null) {
            return null;
        }

        T target = BeanUtils.instantiate(targetClazz);
        convertGenericType(source, target, convertor);

        return target;
    }

    /**
     * <ol>
     * <li>Copy the property values of the given source bean into the target
     * bean.
     * <li>Convert the property values of the given source bean into the target
     * bean using special convertor.
     * </ol>
     * 
     * @param source the source bean
     * @param target the target bean
     * @param convertor the special convertor
     * 
     * @throws BeansException if the copying failed
     * 
     * @see BeanUtils#copyProperties(Object, Object)
     * @see BiConsumer
     */
    public void convertGenericType(S source, T target, BiConsumer<S, T> convertor) {
        if (source == null || target == null) {
            return;
        }

        BeanUtils.copyProperties(source, target);

        if (convertor == null) {
            return;
        }
        convertor.accept(source, target);
    }

    /**
     * <ol>
     * <li>Copy the property values of the given source list for each bean into
     * the target bean.
     * <li>Convert the property values of the given source list for each bean
     * into the target bean using special convertor.
     * <li>Wrap the target bean into a list.
     * </ol>
     * 
     * @param sourceList list converting elements to be added to the target list
     * @param targetClazz the class into which the elements of the target list
     *            are to be stored
     * @param convertor the special convertor
     * 
     * @throws BeansException if the copying failed
     * 
     * @return the target list of converted from the source list
     * 
     * @see BeanUtils#instantiate(Class)
     * @see BeanUtils#copyProperties(Object, Object)
     * @see BiConsumer
     */
    public List<T> convertGenericTypeList(List<S> sourceList, Class<T> targetClazz,
            BiConsumer<S, T> convertor) {
        if (sourceList == null) {
            return null;
        }
        if (sourceList.isEmpty()) {
            return Collections.emptyList();
        }

        T target = null;

        List<T> targetList = new ArrayList<T>(sourceList.size());
        for (S source : sourceList) {
            target = BeanUtils.instantiate(targetClazz);
            convertGenericType(source, target, convertor);
            targetList.add(target);
        }

        return targetList;
    }

}
