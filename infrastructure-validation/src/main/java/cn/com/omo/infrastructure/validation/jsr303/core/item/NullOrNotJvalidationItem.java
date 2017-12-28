/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import cn.com.omo.infrastructure.validation.core.item.NullValidationItem;

/**
 *
 * @date 2017年12月12日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class NullOrNotJvalidationItem extends NullValidationItem implements JvalidationItem {

    private String message;

    public NullOrNotJvalidationItem(Boolean itemValue, String message) {
        super(itemValue);
        setMessage(message);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.JvalidationItem#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
