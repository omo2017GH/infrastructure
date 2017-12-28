package cn.com.omo.infrastructure.common.util;

import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 *
 * @date 2017年12月6日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class InstanceUtils {

    private InstanceUtils() {}

    public static boolean instanceOfString(Object instance) {
        return (instance instanceof String);
    }

    public static boolean instanceOfNumber(Object instance) {
        return (instance instanceof Number);
    }

    public static boolean instanceOfCollection(Object instance) {
        return (instance instanceof Collection);
    }

    public static boolean instanceOfBoolean(Object instance) {
        return (instance instanceof Boolean);
    }

    public static <T> List<T> getListFromArrayObj(Object arrayObj, Class<T> c) {
        if (!arrayObj.getClass().isArray()) {
            return null;
        }
        String jsonString = JSON.toJSONString(arrayObj);
        return JSON.parseArray(jsonString, c);
    }
}
