package cn.com.omo.infrastructure.configuration.core;

import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @date 2017年12月29日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class CacheableMultiSourceConfiguration extends AbstractLocalConfiguration implements InitializingBean {

    private MultiSourceConfiguration multiSourceConf;
    private CacheableConfiguration cacheableConf;

    /**
     * @see cn.com.omo.infrastructure.configuration.core.LocalConfiguration#getStringValue(java.lang.String)
     */
    @Override
    public String getStringValue(String key) {
        String stringValue = cacheableConf.getCacheValue(key);
        if (stringValue == null) {
            stringValue = multiSourceConf.getStringValue(key);
            if (stringValue != null) {
                cacheableConf.storeCache(key, stringValue);
            }
        }

        return stringValue;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (multiSourceConf == null) {
            multiSourceConf = new GeneralMultiSourceConfiguration();
        }
        if (cacheableConf == null) {
            cacheableConf = new GeneralCacheableConfiguration();
        }
    }

    public MultiSourceConfiguration getMultiSourceConf() {
        return multiSourceConf;
    }

    public void setMultiSourceConf(MultiSourceConfiguration multiSourceConf) {
        this.multiSourceConf = multiSourceConf;
    }

    public CacheableConfiguration getCacheableConf() {
        return cacheableConf;
    }

    public void setCacheableConf(CacheableConfiguration cacheableConf) {
        this.cacheableConf = cacheableConf;
    }
}
