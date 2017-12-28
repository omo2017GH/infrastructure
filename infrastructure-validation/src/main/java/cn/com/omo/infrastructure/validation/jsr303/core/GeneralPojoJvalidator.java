package cn.com.omo.infrastructure.validation.jsr303.core;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.omo.infrastructure.validation.core.MultiElementValidator;
import cn.com.omo.infrastructure.validation.jsr303.core.result.JvalidationResult;

/**
 * 通用的pojo对象验证器（基于JSR-303的一个实现）
 * 
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
@Component
public class GeneralPojoJvalidator extends AbstractJvalidator {

    @Resource(name = "SimpleJvalidationDoer")
    private MultiElementValidator validationDoer;

    @Override
    protected JvalidationResult doValidatePojo(Object pojo, Field[] allDeclaredFields) {
        for (Field field : allDeclaredFields) {
            Object fieldValue = getFieldValue(pojo, field);
            validationDoer.addValidationTarget(createValidationTarget(field, fieldValue));
        }

        return (JvalidationResult) validationDoer.vaildateAll();
    }
}
