package cn.com.omo.infrastructure.cache.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @date 2017年12月20日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class ConcurrentLocalCache<T> extends AbstractLocalCache<String, T> {

    private static final Map<String, Object> INTERNAL_CACHE = new ConcurrentHashMap<String, Object>();

    @Override
    public void cacheBean(String key, T value) {
        INTERNAL_CACHE.put(key, value);
    }

    @Override
    public void cleanBean(String key) {
        INTERNAL_CACHE.remove(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected T getBeanFromLocalCache(String key) {
        return (T) INTERNAL_CACHE.get(key);
    }

    @Override
    protected T getBeanFromPlanB(String key) {
        return null;
    }

    @Override
    public boolean isNeedCache(Object bean) {
        return false;
    }
}
