package cn.com.omo.infrastructure.common.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @date 2017年12月21日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DateStringFormatUtils extends DateFormatUtils {

    /**
     * 昨天：yyyyMMdd
     * @return
     */
    public static final String getYesterDay() {
        return getDiffFromToday(-1, DEFAULT_PATTERN);
    }
    
    /**
     * 今天：yyyyMMdd
     * @return
     */
    public static final String getToday() {
        return getDiffFromToday(0, DEFAULT_PATTERN);
    }
    
    /**
     * 明天：yyyyMMdd
     * @return
     */
    public static final String getTomorrow() {
        return getDiffFromToday(1, DEFAULT_PATTERN);
    }

    /**
     * 指定pattern格式化date，date为与当日相差diff天数的日期；
     * diff可为负数（过去）；
     * pattern必须在工具类中已经存在
     * @param diff
     * @return
     */
    public static final String getDiffFromToday(int diff, String pattern) {
        if (isIllegalPattern(pattern)) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diff);

        return formateDate(cal.getTime(), pattern);
    }

    /**
     * 指定pattern格式化date；pattern必须在工具类中已经存在
     * @param date
     * @param pattern
     * @return
     */
    public static final String formateDate(Date date, String pattern) {
        if (date == null || isIllegalPattern(pattern)) {
            return null;
        }

        return getSimpleDateFormat(pattern).format(date);
    }
}
