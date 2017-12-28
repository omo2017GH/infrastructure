/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.configuration.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.com.omo.infrastructure.configuration.core.source.ConfigSource;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractMultiSourceConfigurationService extends AbstractLocalConfigurationService implements MultiSourceConfigurationService {

    @Override
    public String getStringValue(String key) {
        List<ConfigSource> sources = getSources();
        if (sources.isEmpty() || StringUtils.isBlank(key)) {
            return null;
        }

        for (ConfigSource source : sources) {
            String value = source.getValue(key);
            if (value != null) {
                return value;
            }
        }

        return null;
    }
}
