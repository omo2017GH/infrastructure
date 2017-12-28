package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.util.Collection;
import java.util.Map;

import cn.com.omo.infrastructure.common.constant.CommonConstants;
import cn.com.omo.infrastructure.common.util.InstanceUtils;

/**
 *
 * @date 2017年12月12日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class SizeJvalidationItem extends BaseJvalidationItem<String> {

    protected static final Class<?>[] SUPPORTED_TYPE = new Class<?>[] { Collection.class, Map.class,
            CharSequence.class };

    public SizeJvalidationItem(String itemValue, String message) {
        super(itemValue, message);
        setSupportedTypes(SUPPORTED_TYPE);
    }

    /**
     * @see com.huifu.ubs.service.common.model.validation.item.jsr303.BaseJvalidationItem#doCheckData(java.lang.Object)
     */
    @Override
    protected boolean doCheckData(Object data) {
        Class<?> dataClazz = data.getClass();
        int size = 0;
        if (Collection.class.isAssignableFrom(dataClazz)) {
            size = ((Collection<?>) data).size();
        } else if (Map.class.isAssignableFrom(dataClazz)) {
            size = ((Map<?, ?>) data).size();
        } else if (CharSequence.class.isAssignableFrom(dataClazz)) {
            size = ((CharSequence) data).length();
        } else {
            size = InstanceUtils.getListFromArrayObj(data, Object.class).size();
        }

        String[] range = getItemValue().split(CommonConstants.COMMA);
        int min = Integer.valueOf(range[0]);
        int max = Integer.valueOf(range[1]);

        return (min <= size && size <= max);
    }

    @Override
    protected boolean isSupportedOtherSpecialType(Class<?> dataType) {
        return dataType.isArray();
    }
}
