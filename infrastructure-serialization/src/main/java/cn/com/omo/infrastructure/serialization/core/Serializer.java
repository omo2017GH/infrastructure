/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.serialization.core;

/**
 *
 * @date 2017年12月28日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface Serializer {

    String serialize(Object bean);

    <T> T deserialize(String series, Class<T> clazz);
}
