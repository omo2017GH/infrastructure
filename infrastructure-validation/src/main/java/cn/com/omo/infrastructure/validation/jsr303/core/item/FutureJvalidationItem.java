/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @date 2017年12月12日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class FutureJvalidationItem extends BaseDateJvalidationItem {

    public FutureJvalidationItem(String message) {
        super(message);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.BaseJvalidationItem#doCheckData(java.lang.Object)
     */
    @Override
    protected boolean doCheckData(Object data) {
        Class<?> dataClazz = data.getClass();
        if (Date.class.isAssignableFrom(dataClazz)) {
            Date date = (Date) data;
            Date now = new Date();
            return now.before(date);
        } else if (Calendar.class.isAssignableFrom(dataClazz)) {
            Calendar date = (Calendar) data;
            Calendar now = Calendar.getInstance();
            return now.getTimeInMillis() < date.getTimeInMillis();
        }

        return false;
    }
}
