/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.cache.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

/**
 *
 * @date 2017年12月20日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
@Service("GeneralLocalCacheService")
public class GeneralLocalCacheService extends AbstractLocalCacheService<String, Object> {

    private static final Map<String, Object> INTERNAL_CACHE = new ConcurrentHashMap<String, Object>();

    @Override
    public void cacheBean(String key, Object value) {
        INTERNAL_CACHE.put(key, value);
    }

    @Override
    public void cleanBean(String key) {
        INTERNAL_CACHE.remove(key);
    }

    @Override
    protected Object getBeanFromLocalCache(String key) {
        return INTERNAL_CACHE.get(key);
    }

    @Override
    protected Object getBeanFromPlanB(String key) {
        return null;
    }

    @Override
    public boolean isNeedCache(Object bean) {
        return false;
    }
}
