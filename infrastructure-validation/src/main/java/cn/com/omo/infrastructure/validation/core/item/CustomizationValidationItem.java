package cn.com.omo.infrastructure.validation.core.item;

import cn.com.omo.infrastructure.validation.core.checker.ValidationItemChecker;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface CustomizationValidationItem extends ValidationItemChecker<Object> {

    Integer getItemTypeInteger();
}
