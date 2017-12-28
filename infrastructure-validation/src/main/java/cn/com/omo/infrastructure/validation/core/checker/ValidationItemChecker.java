package cn.com.omo.infrastructure.validation.core.checker;

import cn.com.omo.infrastructure.validation.core.item.ValidationItem;

/**
 * 支持泛型T的校验，默认支持data以String类型值的校验
 * @date 2017年12月5日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ValidationItemChecker<T> extends ValidationItem {

    boolean check(T data);
}
