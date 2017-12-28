/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

/**
 *
 * @date 2017年12月12日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class PatternJvalidationItem extends BaseJvalidationItem<String> {

    private static final Class<?>[] SUPPORTED_TYPE = new Class<?>[] { CharSequence.class };

    public PatternJvalidationItem(String itemValue, String message) {
        super(itemValue, message);
        setSupportedTypes(SUPPORTED_TYPE);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.BaseJvalidationItem#doCheckData(java.lang.Object)
     */
    @Override
    protected boolean doCheckData(Object data) {
        String dataStr = data.toString();
        String regex = getItemValue();
        return dataStr.matches(regex);
    }

}
