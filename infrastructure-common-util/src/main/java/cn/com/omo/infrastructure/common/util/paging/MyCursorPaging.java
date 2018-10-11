/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package cn.com.omo.infrastructure.common.util.paging;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @date 2018年10月11日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class MyCursorPaging extends AbstractCursorPagingTemplate<Long> {

    @Override
    protected List<Long> listEntriesBySort(Long lastEntryIndex, Integer entrySizePerPage) {
        System.err.println("entrySizePerPage = " + entrySizePerPage);
        if (lastEntryIndex == 0L) {
            return Arrays.asList(new Long[] { 0L, 1L, 2L });
        }
        if (lastEntryIndex == 2L) {
            return Arrays.asList(new Long[] { 2L, 4L });
        }
        if (lastEntryIndex == 4L) {
            return Arrays.asList(new Long[] { 6L });
        }
        return null;
    }

    @Override
    protected Long getLastEntryIndex(Long dataOfLastEntry) {
        return dataOfLastEntry;
    }

    public static void main(String[] args) {
        MyCursorPaging my = new MyCursorPaging();
        my.consumeLineByLine(System.out :: print, 0L, 3);
    }
}
