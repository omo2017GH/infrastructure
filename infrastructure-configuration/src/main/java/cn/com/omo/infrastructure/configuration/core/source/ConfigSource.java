/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.configuration.core.source;

import org.springframework.core.Ordered;

/**
 * 配置源，配置项的获取方式。支持多个配置源，配置项根据优先级从配置源依次查找，若查找的值不为null，则立刻返回配置项
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ConfigSource extends Ordered {

    /**
     * 配置项key值对应的value
     * @param key
     * @return
     */
    String getValue(String key);
}
