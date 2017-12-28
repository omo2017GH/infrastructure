/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.configuration.core;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.cache.core.LocalCacheService;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class GeneralCacheableConfigurationService extends AbstractCacheableConfigurationService {

    private static LocalCacheService<String, String> configs;

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

    public static void setConfigs(LocalCacheService<String, String> configs) {
        GeneralCacheableConfigurationService.configs = configs;
    }
}
