package cn.com.omo.infrastructure.validation.jsr303.core;

import java.lang.reflect.Field;

import cn.com.omo.infrastructure.validation.jsr303.JvalidationHelper;
import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;

/**
 *
 * @date 2017年12月13日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class AbstractJvalidator extends JvalidationHelper implements Jvalidator {

    /**
     * @see com.huifu.ubs.service.common.model.validation.jsr303.Jvalidator#validate(java.lang.Object)
     */
    @Override
    public JvalidationResult validate(Object pojo) {
        if (pojo == null) {
            getDefaultSuccessResult();
        }

        Field[] allDeclaredFields = getAllDeclaredFields(pojo.getClass());
        if (allDeclaredFields == null || allDeclaredFields.length == 0) {
            return getDefaultSuccessResult();
        }

        return doValidatePojo(pojo, allDeclaredFields);
    }

    protected abstract JvalidationResult doValidatePojo(Object pojo, Field[] allDeclaredFields);

}
