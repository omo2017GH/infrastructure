/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.serialization;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.com.omo.infrastructure.serialization.core.Serializer;

/**
 *
 * @date 2017年12月28日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class SerializationFactory {

    public static Serializer getGsonSerializer() {
        return SerializerHolder.getGsonSerializer();
    }

    public static Serializer getFastJsonSerializer() {
        return SerializerHolder.getFastJsonSerializer();
    }

    private static class SerializerHolder {

        private static Serializer GSON_SERIALIZER = null;
        private static Serializer FAST_JOSN_SERIALIZER = null;

        private static Serializer getGsonSerializer() {
            if (GSON_SERIALIZER == null) {
                GSON_SERIALIZER = new Serializer() {

                    private final Gson GSON = new GsonBuilder().enableComplexMapKeySerialization()
                            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                    @Override
                    public String serialize(Object bean) {
                        return GSON.toJson(bean);
                    }

                    @Override
                    public <T> T deserialize(String series, Class<T> clazz) {
                        return GSON.fromJson(series, clazz);
                    }
                };
            }

            return GSON_SERIALIZER;
        }

        private static Serializer getFastJsonSerializer() {
            if (FAST_JOSN_SERIALIZER == null) {
                FAST_JOSN_SERIALIZER = new Serializer() {

                    @Override
                    public String serialize(Object bean) {
                        return JSON.toJSONString(bean);
                    }

                    @Override
                    public <T> T deserialize(String series, Class<T> clazz) {
                        return JSON.parseObject(series, clazz);
                    }
                };
            }

            return FAST_JOSN_SERIALIZER;
        }
    }
}
