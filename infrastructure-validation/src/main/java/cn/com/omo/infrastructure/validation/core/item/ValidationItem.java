package cn.com.omo.infrastructure.validation.core.item;

/**
 * 校验项
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface ValidationItem {

    /**
     * 校验项参考值
     * @see ValidationItemEnum
     * @return
     */
    Object getItemValue();
}
