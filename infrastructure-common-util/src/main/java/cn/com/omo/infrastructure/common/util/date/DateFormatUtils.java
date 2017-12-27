package cn.com.omo.infrastructure.common.util.date;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @date 2017年11月30日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DateFormatUtils {

    /**
     * yyyyMMdd
     */
    public static final String DEFAULT_PATTERN = "yyyyMMdd";
    
    /**
     * yyyyMMdd HH:mm:ss
     */
    public static final String PATTERN_1 = "yyyyMMdd HH:mm:ss";
    
    /**
     * yyyyMMddHHmmss
     */
    public static final String PATTERN_2 = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd
     */
    public static final String PATTERN_3 = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_4 = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String PATTERN_5 = "yyyy-MM-dd HH:mm:ss.SSS";

    private static final Map<String, SimpleDateFormat> PATTERN_MAP = new HashMap<String, SimpleDateFormat>(10);

    static {
        PATTERN_MAP.put(DEFAULT_PATTERN, new SimpleDateFormat(DEFAULT_PATTERN));
        PATTERN_MAP.put(PATTERN_1, new SimpleDateFormat(PATTERN_1));
        PATTERN_MAP.put(PATTERN_2, new SimpleDateFormat(PATTERN_2));
        PATTERN_MAP.put(PATTERN_3, new SimpleDateFormat(PATTERN_3));
        PATTERN_MAP.put(PATTERN_4, new SimpleDateFormat(PATTERN_4));
        PATTERN_MAP.put(PATTERN_5, new SimpleDateFormat(PATTERN_5));
    }

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        if (isIllegalPattern(datePattern)) {
            return PATTERN_MAP.get(DEFAULT_PATTERN);
        }

        return PATTERN_MAP.get(datePattern);
    }


    public static final boolean isIllegalPattern(String pattern) {
        if (pattern == null) {
            return true;
        }

        if (PATTERN_MAP.get(pattern) == null) {
            return true;
        }

        return false;
    }
}
