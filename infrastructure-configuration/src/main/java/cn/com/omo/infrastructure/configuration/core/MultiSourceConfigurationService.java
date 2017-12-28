/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.configuration.core;

import java.util.List;

import cn.com.omo.infrastructure.configuration.core.source.ConfigSource;

/**
 *
 * @date 2017年12月18日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public interface MultiSourceConfigurationService extends LocalConfigurationService {

    void addSource(ConfigSource source);

    List<ConfigSource> getSources();

    void sortSources();
}
