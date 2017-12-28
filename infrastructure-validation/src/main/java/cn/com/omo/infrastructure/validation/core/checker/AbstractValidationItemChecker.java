package cn.com.omo.infrastructure.validation.core.checker;

/**
 *
 * @date 2017年12月5日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class AbstractValidationItemChecker<T> implements ValidationItemChecker<T> {

    /**
     * @see com.huifu.ubs.service.common.model.validation.checker.ValidationItemChecker#check(java.lang.Object)
     */
    @Override
    public boolean check(T data) {
        Object itemValue = getItemValue();
        if (itemValue == null) {
            return true;
        }

        return checkData(data);
    }

    protected abstract boolean checkData(T data);

}
