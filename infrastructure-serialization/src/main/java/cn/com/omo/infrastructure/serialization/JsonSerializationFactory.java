/**
 * Copyright: Copyright (c) 2018
 * Company: www.91wutong.com
 */

package cn.com.omo.infrastructure.serialization;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.com.omo.infrastructure.serialization.core.Serializer;
import cn.com.omo.infrastructure.serialization.exception.DeserializationException;
import cn.com.omo.infrastructure.serialization.exception.SerializationException;

/**
 * 
 * @date 2018年2月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 0.0.1-SNAPSHOT
 */
public class JsonSerializationFactory {

    public static Serializer getGsonSerializer() {
        return SerializerHolder.getGsonSerializer();
    }

    public static Serializer getFastJsonSerializer() {
        return SerializerHolder.getFastJsonSerializer();
    }

    public static Serializer getJacksonSerializer() {
        return SerializerHolder.getJacksonSerializer();
    }

    private static class SerializerHolder {

        private static Serializer GSON_SERIALIZER = null;
        private static Serializer FAST_JOSN_SERIALIZER = null;
        private static Serializer JACKSON_SERIALIZER = null;

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
        
        private static Serializer getJacksonSerializer() {
            if (JACKSON_SERIALIZER == null) {
                JACKSON_SERIALIZER = new Serializer() {

                    private final ObjectMapper MAPPER = new ObjectMapper();

                    @Override
                    public String serialize(Object bean) {
                        try {
                            return MAPPER.writeValueAsString(bean);
                        } catch (JsonProcessingException e) {
                            throw new SerializationException("", e);
                        }
                    }
                    
                    @Override
                    public <T> T deserialize(String series, Class<T> clazz) {
                        try {
                            return MAPPER.readValue(series, clazz);
                        } catch (IOException e) {
                            throw new DeserializationException("", e);
                        }
                    }
                };
            }
            
            return JACKSON_SERIALIZER;
        }
    }

}
