package cn.com.omo.infrastructure.configuration.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import cn.com.omo.infrastructure.cache.core.ConcurrentLocalCache;
import cn.com.omo.infrastructure.cache.core.LocalCache;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class GeneralCacheableConfigurationService extends AbstractCacheableConfigurationService implements InitializingBean {

    private LocalCache<String, String> configs;

    @Override
    public String getCacheValue(String key) {
        return configs.getBean(key);
    }

    @Override
    public void storeCache(String key, String value) {
        if (value == null) {
            return;
        }
        configs.cacheBean(key, value);
    }

    @Override
    public void cleanCache(String key) {
        if (!StringUtils.isBlank(key) && getCacheValue(key) != null) {
            configs.cleanBean(key);
        }
    }

    @Override
    protected String getStringValueFromPlanB(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setConfigs(LocalCache<String, String> configs) {
        this.configs = configs;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (configs == null) {
            configs = new ConcurrentLocalCache<String>();
        }
    }
}
