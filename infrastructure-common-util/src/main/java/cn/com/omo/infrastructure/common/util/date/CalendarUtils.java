package cn.com.omo.infrastructure.common.util.date;

import java.util.Calendar;

/**
 *
 * @date 2017年12月21日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class CalendarUtils {

    public static final Calendar adjustMinute(int minuteDiff) {
        return adjust(0, 0, 0, 0, minuteDiff, 0);
    }

    public static final Calendar adjustHour(int hourDiff) {
        return adjust(0, 0, 0, hourDiff, 0, 0);
    }

    /**
     * 调整日历的天数
     * @param dayDiff
     * @return
     */
    public static final Calendar adjustDay(int dayDiff) {
        return adjust(0, 0, dayDiff, 0, 0, 0);
    }

    /**
     * 调整日历的年月日时分秒
     * @param yearDiff
     * @param monthDiff
     * @param dayDiff
     * @param hourDiff
     * @param minuteDiff
     * @param secDiff
     * @return
     */
    public static final Calendar adjust(int yearDiff, int monthDiff, int dayDiff, int hourDiff, int minuteDiff,
            int secDiff) {

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.YEAR, yearDiff);
        ca.add(Calendar.MONTH, monthDiff);
        ca.add(Calendar.DATE, dayDiff);
        ca.add(Calendar.HOUR_OF_DAY, hourDiff);
        ca.add(Calendar.MINUTE, minuteDiff);
        ca.add(Calendar.SECOND, secDiff);

        return ca;
    }
}
