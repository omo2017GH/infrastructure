package cn.com.omo.infrastructure.validation.jsr303.core.target;

import cn.com.omo.infrastructure.validation.core.target.ValidationTarget;
import cn.com.omo.infrastructure.validation.jsr303.core.item.JvalidationItem;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface JvalidationTarget extends ValidationTarget<Object> {

    JvalidationItem[] getJvalidationItems();
}
