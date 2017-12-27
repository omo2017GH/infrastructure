package cn.com.omo.infrastructure.common.util.date;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2017年12月21日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class DateTimeFormatUtils extends DateFormatUtils {

    /**
     * 指定pattern解析date；pattern必须在工具类中已经存在
     * @param date
     * @param pattern
     * @return
     */
    public static final Date parseDateString(String date, String pattern) {
        if (StringUtils.isBlank(date) || isIllegalPattern(pattern)) {
            return null;
        }

        try {
            return getSimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            IllegalArgumentException ex = new IllegalArgumentException("非法参数：日期date=" + date, e);
            throw ex;
        }
    }
}
