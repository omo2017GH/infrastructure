package cn.com.omo.infrastructure.configuration.core.source;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 *
 * @date 2017年12月28日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
@Component
public class LocalPropertiesConfigSource extends AbstractConfigSource implements InitializingBean {

    private static final String DEFAULT_PROP_PATH = "classpath*:";

    private static final String DEFAULT_PROP_SUFFIX = "*.properties";

    private String localPropertiesPath = DEFAULT_PROP_PATH + DEFAULT_PROP_SUFFIX;

    private ResourcePatternResolver loader = new PathMatchingResourcePatternResolver();

    private Resource[] resources;

    private Properties props;

    /**
     * @see org.springframework.core.Ordered#getOrder()
     */
    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    /**
     * @see cn.com.omo.infrastructure.configuration.core.source.AbstractConfigSource#doGet(java.lang.String)
     */
    @Override
    protected String doGet(String key) {
        return props.getProperty(key);
    }

    public void setLocalPropertiesPath(String localPropertiesPath) {
        if (StringUtils.isBlank(localPropertiesPath)) {
            return;
        }

        this.localPropertiesPath = localPropertiesPath;
    }

    private void loadProperties() {
        props = new Properties();
        Properties tmpProps = new Properties();
        for (Resource resource : resources) {
            try {
                tmpProps.load(resource.getInputStream());
                props.putAll(tmpProps);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadResources() throws Exception {
        try {
            resources = loader.getResources(localPropertiesPath);
            if (resources == null) {
                throw new IOException("resources has not loaded");
            }
        } catch (IOException e) {
            throw new Exception("加载资源异常", e);
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadResources();
        loadProperties();
    }
}
