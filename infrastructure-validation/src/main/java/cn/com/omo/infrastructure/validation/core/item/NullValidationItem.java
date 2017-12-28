package cn.com.omo.infrastructure.validation.core.item;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class NullValidationItem extends BaseBooleanValidationItem<Object> {

    public NullValidationItem(Boolean itemValue) {
        super(itemValue);
    }

    @Override
    protected boolean checkData(Object data) {
        if (getItemValue() && data == null) {
            return true;
        }
        if (!getItemValue() && data != null) {
            return true;
        }
        return false;
    }
}
