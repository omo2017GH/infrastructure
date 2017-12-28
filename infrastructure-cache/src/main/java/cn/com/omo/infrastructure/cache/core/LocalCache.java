package cn.com.omo.infrastructure.cache.core;

/**
 * 本地缓存服务</br>
 * 适用于数据字典等相对固定的
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface LocalCache<K, V> {

    /**
     * 从本地缓存中获取bean（Key为null时返回null）
     * @param key
     * @return
     */
    V getBean(K key);

    /**
     * 缓存bean
     * @param key
     * @param value
     */
    void cacheBean(K key, V value);

    /**
     * 从本地缓存中清除bean
     * @param key
     */
    void cleanBean(K key);
}
