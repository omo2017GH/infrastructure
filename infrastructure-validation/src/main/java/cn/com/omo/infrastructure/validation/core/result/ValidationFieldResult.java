/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.core.result;

/**
 * 校验field结果对象
 * @date 2017年11月24日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class ValidationFieldResult extends SimpleValidationResult {

    /**
     * 
     */
    private static final long serialVersionUID = -6250412815445680297L;

    /**
     * 字段的class
     */
    private Class<?> fieldClazz;

    /**
     * 字段实例
     */
    private Object fieldObj;

    /**
     * 字段名
     */
    private String fieldName;

    public Class<?> getFieldClazz() {
        return fieldClazz;
    }

    public void setFieldClazz(Class<?> fieldClazz) {
        this.fieldClazz = fieldClazz;
    }

    public Object getFieldObj() {
        return fieldObj;
    }

    public void setFieldObj(Object fieldObj) {
        this.fieldObj = fieldObj;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
