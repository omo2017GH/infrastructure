package cn.com.omo.infrastructure.configuration.core;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cn.com.omo.infrastructure.cache.Cacheable;
import cn.com.omo.infrastructure.cache.core.ConcurrentLocalCache;
import cn.com.omo.infrastructure.cache.core.LocalCache;
import cn.com.omo.infrastructure.configuration.core.source.ConfigSource;

/**
 *
 * @date 2017年12月18日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class GeneralLocalConfiguration extends AbstractLocalConfiguration implements Cacheable, InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, ConfigSource> configSources;

    private LocalCache<String, String> cache;

    private MultiSourceConfiguration configs;

    private boolean needCache = true;

    @Override
    public String getStringValue(String key) {
        String bean = cache.getBean(key);
        if (bean == null) {
            bean = configs.getStringValue(key);
            if (isNeedCache(bean)) {
                cache.cacheBean(key, bean);
            }
        }

        return bean;
    }

    @Override
    public boolean isNeedCache(Object bean) {
        if (bean != null && needCache) {
            return true;
        }

        return false;
    }

    public void setCache(LocalCache<String, String> cache) {
        this.cache = cache;
    }

    public void setConfigs(MultiSourceConfiguration configs) {
        this.configs = configs;
    }

    public void setNeedCache(boolean needCache) {
        this.needCache = needCache;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        checkApplicationContext();
        loadConfigSources();
        loadLocalCache();
        loadMultiSourceConfiguration();
    }

    private void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalArgumentException("Spring.applicationContext must not be null");
        }
    }

    private void loadConfigSources() {
        configSources = applicationContext.getBeansOfType(ConfigSource.class);
        if (configSources == null || configSources.isEmpty()) {
            throw new IllegalArgumentException("ConfigSource must not be null");
        }
    }

    private void loadLocalCache() {
        if (cache == null) {
            cache = new ConcurrentLocalCache<String>();
        }
    }

    private void loadMultiSourceConfiguration() {
        if (configs == null) {
            configs = new GeneralMultiSourceConfiguration();
        }

        for (Entry<String, ConfigSource> configSource: configSources.entrySet()) {
            configs.addSource(configSource.getValue());
        }

        configs.sortSources();
    }
}
