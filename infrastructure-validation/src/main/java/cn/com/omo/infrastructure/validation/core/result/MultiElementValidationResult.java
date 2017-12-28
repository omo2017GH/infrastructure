package cn.com.omo.infrastructure.validation.core.result;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface MultiElementValidationResult extends Serializable {

    /**
     * 校验是否通过
     */
    boolean isPass();

    /**
     * 获取非法的元素集合，非法的元素以[字段名称-字段值]的键值形式返回
     * @return
     */
    Map<String, String> getIllegalElements();

}
