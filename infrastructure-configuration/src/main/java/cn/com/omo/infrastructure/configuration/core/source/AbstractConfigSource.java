/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.configuration.core.source;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class AbstractConfigSource implements ConfigSource {

    /**
     * @see com.huifu.ubs.service.common.configuration.source.ConfigSource#getValue(java.lang.String)
     */
    @Override
    public String getValue(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        return doGet(key);
    }

    protected abstract String doGet(String key);
}
