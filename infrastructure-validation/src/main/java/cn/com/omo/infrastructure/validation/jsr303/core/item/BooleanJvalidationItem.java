/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

/**
 *
 * @date 2017年12月7日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class BooleanJvalidationItem extends BaseJvalidationItem<Boolean> {

    private static final Class<?>[] SUPPORTED_TYPE = new Class<?>[] { Boolean.class, boolean.class };

    public BooleanJvalidationItem(Boolean itemValue, String message) {
        super(itemValue, message);
        setSupportedTypes(SUPPORTED_TYPE);
    }

    @Override
    protected boolean doCheckData(Object data) {
        boolean dataBoolean = (Boolean) data;
        return dataBoolean == getItemValue().booleanValue();
    }

}
