package cn.com.omo.infrastructure.validation.jsr303.core;

import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;

/**
 *
 * @date 2017年12月13日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface Jvalidator {

    JvalidationResult validate(Object pojo);
}
