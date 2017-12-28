package cn.com.omo.infrastructure.cache;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface Cacheable {

    boolean isNeedCache(Object bean);
}
