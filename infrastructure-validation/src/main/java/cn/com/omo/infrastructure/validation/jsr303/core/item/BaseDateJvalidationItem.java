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
public abstract class BaseDateJvalidationItem extends BaseJvalidationItem<Boolean> {

    protected static final Class<?>[] SUPPORTED_TYPE = new Class<?>[] { Date.class, Calendar.class };

    public BaseDateJvalidationItem(String message) {
        super(Boolean.TRUE, message);
        setSupportedTypes(SUPPORTED_TYPE);
    }
}
