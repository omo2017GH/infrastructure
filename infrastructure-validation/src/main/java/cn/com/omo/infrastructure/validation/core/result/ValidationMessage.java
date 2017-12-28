package cn.com.omo.infrastructure.validation.core.result;

import java.util.Map;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ValidationMessage {

    /**
     * 获取非法元素信息，非法的元素以[字段名称-message]的键值形式返回
     * @return
     */
    Map<String, String> getIllegalElementMessages();

}
