/**
 * 
 */
package cn.com.omo.infrastructure.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * 反射工具
 * @author hezh
 * @since 2016/08/12
 */
public class AnnotationUtils {

    private AnnotationUtils() {}

    /**
	 * 获取clazz的父类集合
	 * @param clazz
	 * @return
	 */
	public static List<Class<?>> getClazzExtensions(Class<?> clazz) {
		List<Class<?>> cl = new ArrayList<Class<?>>();
		Class<?> b = clazz;
		while (!Object.class.equals(b)) {
			cl.add(b);
			b = b.getSuperclass();
		}

		return cl;
	}

	public static boolean isAnnoClazz(Class<?> clazz, Class<? extends Annotation> anno) {
		Annotation annotation = clazz.getAnnotation(anno);
		if (annotation == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean isAnnoField(Field field, Class<? extends Annotation> anno) {
		Annotation annotation = field.getAnnotation(anno);
		if (annotation == null) {
			return false;
		}
		else {
			return true;
		}
	}

	public static String getFieldSingleStringValue(Object obj, String fieldName) {
		try {
			return BeanUtils.getProperty(obj, fieldName);
		} catch (Exception e) {
			return null;
		}
	}

	public static Object getFieldObjectValue(Object obj, String fieldName) {
		BeanUtilsBean bean = new BeanUtilsBean();
		try {
			return bean.getPropertyUtils().getNestedProperty(obj, fieldName);
		} catch (Exception e) {
			return null;
		}
	}
}
