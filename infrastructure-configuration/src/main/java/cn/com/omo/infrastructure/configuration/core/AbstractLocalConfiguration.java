package cn.com.omo.infrastructure.configuration.core;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.common.util.number.NumberFormatterUtils;

/**
 *
 * @date 2017年12月11日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public abstract class AbstractLocalConfiguration implements LocalConfiguration {

    private static final String TRUE_STRING = "TRUE";
    private static final String FALSE_STRING = "FALSE";

    /**
     * @see com.LocalConfiguration.ubs.service.common.configuration.LocalConfigurationService#getBooleanValue(java.lang.String)
     */
    @Override
    public Boolean getBooleanValue(String key) {
        String stringValue = getStringValue(key);
        if (TRUE_STRING.equalsIgnoreCase(stringValue.trim())) {
            return Boolean.TRUE;
        } else if (FALSE_STRING.equalsIgnoreCase(stringValue.trim())) {
            return Boolean.FALSE;
        } else {
            return null;
        }
    }

    /**
     * @see com.LocalConfiguration.ubs.service.common.configuration.LocalConfigurationService#getIntegerValue(java.lang.String)
     */
    @Override
    public Integer getIntegerValue(String key) {
        BigDecimal bigDecimalValue = getBigDecimalValue(key);
        return bigDecimalValue == null ? null : bigDecimalValue.intValue();
    }

    /**
     * @see com.LocalConfiguration.ubs.service.common.configuration.LocalConfigurationService#getBigDecimalValue(java.lang.String)
     */
    @Override
    public BigDecimal getBigDecimalValue(String key) {
        String stringValue = getStringValue(key);
        if (!NumberFormatterUtils.isNumber(stringValue)) {
            return null;
        }
        return new BigDecimal(stringValue);
    }

}
