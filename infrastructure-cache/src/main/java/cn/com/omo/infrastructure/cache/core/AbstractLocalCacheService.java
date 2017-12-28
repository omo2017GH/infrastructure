package cn.com.omo.infrastructure.cache.core;

import cn.com.omo.infrastructure.cache.Cacheable;

/**
 *
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractLocalCacheService<K, V> implements LocalCacheService<K, V>, Cacheable {

    @Override
    public V getBean(K key) {
        V bean = getBeanFromLocalCache(key);
        if (bean == null) {
            bean = getBeanFromPlanB(key);

            if (isNeedCache(bean)) {
                cacheBean(key, bean);
            }
        }

        return bean;
    }

    @Override
    public boolean isNeedCache(Object bean) {
        if (bean != null) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract V getBeanFromLocalCache(K key);

    protected abstract V getBeanFromPlanB(K key);
}
