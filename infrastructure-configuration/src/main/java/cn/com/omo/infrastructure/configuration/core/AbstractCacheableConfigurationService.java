package cn.com.omo.infrastructure.configuration.core;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractCacheableConfigurationService extends AbstractLocalConfigurationService
        implements CacheableConfigurationService {

    @Override
    public String getStringValue(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        String stringValue = getCacheValue(key);
        if (stringValue == null) {
            stringValue = getStringValueFromPlanB(key);
            if (isNeedCache(stringValue)) {
                storeCache(key, stringValue);
            }
        }

        return stringValue;
    }

    protected abstract String getStringValueFromPlanB(String key);

    @Override
    public boolean isNeedCache(Object bean) {
        if (bean == null) {
            return false;
        }

        return true;
    }
}
