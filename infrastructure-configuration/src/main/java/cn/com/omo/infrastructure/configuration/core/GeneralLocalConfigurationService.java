package cn.com.omo.infrastructure.configuration.core;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import cn.com.omo.infrastructure.configuration.core.source.ConfigSource;

/**
 *
 * @date 2017年12月18日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
@Service("GeneralLocalConfigurationService")
public class GeneralLocalConfigurationService extends GeneralCacheableConfigurationService implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private MultiSourceConfigurationService configs;

    @Override
    protected String getStringValueFromPlanB(String key) {
        return configs.getStringValue(key);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (applicationContext == null) {
            throw new IllegalArgumentException("Spring.applicationContext must not be null");
        }

        Map<String, ConfigSource> configSources = applicationContext.getBeansOfType(ConfigSource.class);
        if (configSources == null || configSources.isEmpty()) {
            throw new IllegalArgumentException("ConfigSource must not be null");
        }

        configs = new GeneralMultiSourceConfigurationService();
        for (Entry<String, ConfigSource> configSource: configSources.entrySet()) {
            configs.addSource(configSource.getValue());
        }
        configs.sortSources();
    }
}
