package cn.com.omo.infrastructure.common.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2017年11月22日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class NumberFormatterUtils {

    private NumberFormatterUtils() {}

    private static final String LEFT_PADDING_ZERO_PATTERN = "%0[D]d";

    public static String leftPaddingZero4Ten(long number) {
        return leftPaddingZero(number, 10);
    }

    public static String leftPaddingZero(long number, int digit) {
        if (digit <= 0) {
            return String.valueOf(number);
        }

        String digitStr = String.valueOf(digit);
        String pattern = LEFT_PADDING_ZERO_PATTERN.replace("[D]", digitStr);
        return String.format(pattern, number);
    }

    public static boolean isNumber(String numStr) {
        if (StringUtils.isBlank(numStr)) {
            return false;
        }
        return parseNumber(numStr) != null;
    }

    public static BigDecimal parseNumber(String numStr) {
        try {
            return new BigDecimal(numStr);
        } catch (Exception e) {
            return null;
        }
    }
}
