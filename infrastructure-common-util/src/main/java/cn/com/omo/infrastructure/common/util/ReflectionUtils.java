package cn.com.omo.infrastructure.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public final class ReflectionUtils {

    /**
     * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
     * 
     * @param object
     * @param fieldName
     * @return
     */
    public static final Object getFieldValue(Object object, String fieldName) {
        Field field = getDeclaredField(object, fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
     * 
     * @param object
     * @param Field field
     * @return
     */
    public static final Object getFieldValue(Object object, Field field) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
     * 
     * @param object
     * @param fieldName
     * @param value
     */
    public static final void setFieldValue(Object object, String fieldName, Object value) {
        Field field = getDeclaredField(object, fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 循环向上转型,获取对象的DeclaredField.
     * 
     * @param object
     * @param fieldName
     * @return
     */
    public static final Field getDeclaredField(Object object, String fieldName) {
        return getDeclaredField(object.getClass(), fieldName);
    }

    /**
     * 循环向上转型,获取类的DeclaredField.
     * 
     * @param clazz
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     */
    public static final Field getDeclaredField(Class<?> clazz, String fieldName) {
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                // Field不在当前类定义,继续向上寻找
                continue;
            }
        }

        return null;
    }

    /**
     * 获取类及超类的declared fields
     * 
     * @param clazz
     * @return
     */
    public static final Field[] getALLDeclaredFields(Class<?> clazz) {
        Set<Field> tmp = new HashSet<Field>();
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            Field[] declaredFields = superClass.getDeclaredFields();
            if (declaredFields == null || declaredFields.length == 0) {
                continue;
            }
            Collections.addAll(tmp, declaredFields);
        }

        if (tmp.isEmpty()) {
            return null;
        } else {
            return tmp.toArray(new Field[0]);
        }
    }

    /**
     * 获取类及超类的private declared fields
     * 
     * @param clazz
     * @return
     */
    public static final Field[] getPrivateDeclaredFields(Class<?> clazz) {
        Set<Field> tmp = new HashSet<Field>();
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            Field[] declaredFields = superClass.getDeclaredFields();
            if (declaredFields == null || declaredFields.length == 0) {
                continue;
            }

            // 按照javabean的自省方式，仅获取private字段
            for (Field declaredField : declaredFields) {
                int mods = declaredField.getModifiers();
                if (Modifier.isPrivate(mods) && !Modifier.isStatic(mods) && !Modifier.isFinal(mods)) {
                    tmp.add(declaredField);
                }
            }
        }

        if (tmp.isEmpty()) {
            return null;
        } else {
            return tmp.toArray(new Field[0]);
        }
    }

    /**
     * 直接调用对象方法,无视private/protected修饰符
     * 
     * @param object
     * @param methodName
     * @param parameters
     * @return
     */
    public static final Object callMethod(Object object, String methodName, Object... parameters) {
        Method method = getDeclaredMethod(object, methodName, parameters);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        try {
            return method.invoke(object, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 循环向上转型,获取类的DeclaredMehtod.
     * 
     * @param object
     * @param methodName
     * @param parameters
     * @return
     */
    public static final Method getDeclaredMethod(Object object, String methodName, Object... parameters) {
        if (ArrayUtils.isEmpty(parameters)) {
            return null;
        }

        Class<?>[] parameterTypes = null;
        Collection<Class<?>> temp = new LinkedList<Class<?>>();
        for (Object parameter : parameters) {
            temp.add(parameter.getClass());
        }
        parameterTypes = temp.toArray(new Class[temp.size()]);
        return getDeclaredMethod(object.getClass(), methodName, parameterTypes);
    }

    /**
     * 循环向上转型,获取类的DeclaredMehtod.
     * 
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static final Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        return getDeclaredMethod(object.getClass(), methodName, parameterTypes);
    }

    /**
     * 循环向上转型,获取类的DeclaredMehtod.
     * 
     * @param clazz
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static final Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                // Field不在当前类定义,继续向上寻找
                continue;
            }
        }

        return null;
    }

    /**
     * 得到指定class实现的接口中指定位置的范型参数
     * 
     * @param clazz
     * @param i 第几个接口
     * @param j 接口中第几个范型参数
     * @return
     */
    public static Class<?> getInterfaceGenricType(Class<?> clazz, int i, int j) {
        Type interfaceType = clazz.getGenericInterfaces()[i];
        if (!(interfaceType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) interfaceType).getActualTypeArguments();
        if (!(params[j] instanceof Class)) {
            return Object.class;
        }

        return (Class<?>) params[j];
    }

    /**
     * 得到指定class实现的第一个接口的第一个范型参数
     * 
     * @param clazz
     * @return
     */
    public static Class<?> getInterfaceGenricType(Class<?> clazz) {
        return getInterfaceGenricType(clazz, 0, 0);
    }

    /**
     * 得到指定class指定位置的范型参数
     * 
     * @param clazz
     * @param index
     * @return
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
        Type superClassType = clazz.getGenericSuperclass();
        if (!(superClassType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) superClassType).getActualTypeArguments();
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class<?>) params[index];
    }

    /**
     * 得到指定class的第一个范型参数
     * 
     * @param clazz
     * @return
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> clazz, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException | SecurityException e) {
            return null;
        }
    }

    public static Class<?> convertPrimitive2Wrapper(Class<?> primitiveType) {
        if (primitiveType.equals(boolean.class)) {
            return Boolean.class;
        }
        if (primitiveType.equals(byte.class)) {
            return Byte.class;
        }
        if (primitiveType.equals(char.class)) {
            return Character.class;
        }
        if (primitiveType.equals(double.class)) {
            return Double.class;
        }
        if (primitiveType.equals(float.class)) {
            return Float.class;
        }
        if (primitiveType.equals(int.class)) {
            return Integer.class;
        }
        if (primitiveType.equals(long.class)) {
            return Long.class;
        }
        if (primitiveType.equals(short.class)) {
            return Short.class;
        }

        return null;
    }
}
