package cn.com.omo.infrastructure.configuration.core;

import cn.com.omo.infrastructure.cache.Cacheable;

/**
 *
 * @date 2017年12月18日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface CacheableConfigurationService extends LocalConfigurationService, Cacheable {

    String getCacheValue(String key);

    void storeCache(String key, String value);

    void cleanCache(String key);
}
