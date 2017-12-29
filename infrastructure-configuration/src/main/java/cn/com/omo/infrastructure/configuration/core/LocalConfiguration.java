package cn.com.omo.infrastructure.configuration.core;

import java.math.BigDecimal;

/**
 * 根据key值获取配置的value。若key值没有对应的value则返回null；若配置的value和方法对应的返回值类型不匹配，则即便有该配置项，也会返回null
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface LocalConfiguration {

    String getStringValue(String key);
    
    Boolean getBooleanValue(String key);
    
    Integer getIntegerValue(String key);
    
    BigDecimal getBigDecimalValue(String key);
}
