package cn.com.omo.infrastructure.validation.core;

import cn.com.omo.infrastructure.validation.core.result.ValidationResult;
import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;

/**
 * 校验实体接口
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface Validator {

    <T> ValidationResult vaildate(ValidationTarget<T> validationTarget);
}
