package cn.com.omo.infrastructure.configuration.core;

import java.util.LinkedList;
import java.util.List;

import cn.com.omo.infrastructure.comparison.core.CommonSorter;
import cn.com.omo.infrastructure.comparison.core.Sorter;
import cn.com.omo.infrastructure.configuration.core.source.ConfigSource;

/**
 *
 * @date 2017年12月18日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class GeneralMultiSourceConfigurationService extends AbstractMultiSourceConfigurationService {

    private List<ConfigSource> sources = new LinkedList<ConfigSource>();
    private Sorter sorter = new CommonSorter();

    @Override
    public List<ConfigSource> getSources() {
        return sources;
    }

    @Override
    public void addSource(ConfigSource source) {
        if (source == null) {
            return;
        }

        sources.add(source);
    }

    @Override
    public void sortSources() {
        if (sources.size() <= 1) {
            return;
        }

        sorter.sort(sources);
    }
}
