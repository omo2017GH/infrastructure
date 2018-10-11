/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package cn.com.omo.infrastructure.common.util.paging;

import java.util.List;
import java.util.function.Consumer;

/**
 * <h3>游标分页基类</h3>
 * 
 * @date 2018年10月11日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public abstract class AbstractCursorPagingTemplate<T> {

    /**
     * <h3>游标分页基类</h3>
     * </p>
     * 
     * 逐行处理通过游标分页法返回的批量数据：</br>
     * 1.条目有唯一的 {@code Long} 索引 </br>
     * 2.当次分页的起点从上一页最后一条数据的索引并根据索引排序算法开始往后抓取数据 </br>
     * 3.一页抓取的数据量由 {@code entrySizePerPage} 决定
     * 
     * @param consumer 类型为 T 的消费者（处理逻辑）
     * @param startEntryIndex 分页起始条目索引
     * @param entrySizePerPage 一页抓取的数据量
     */
    public void consumeLineByLine(Consumer<T> consumer, Long startEntryIndex, Integer entrySizePerPage) {
        List<T> entries = listEntriesBySort(startEntryIndex, entrySizePerPage);

        while (entries != null && !entries.isEmpty()) {
            entries.forEach(consumer);
            T lastEntry = entries.get(entries.size() - 1);
            Long lastEntryIndex = getLastEntryIndex(lastEntry);
            entries = listEntriesBySort(lastEntryIndex, entrySizePerPage);
        }
    }

    /**
     * <h3>获取分页条目</h3>
     * </p>
     * 
     * 当次分页的起点从上一页最后一条数据的索引并根据索引排序算法开始往后抓取数据
     * 
     * @param lastEntryIndex 上一页最后一条数据的索引
     * @param entrySizePerPage 一页抓取的数据量
     * @return 类型是 T 的列表
     */
    protected abstract List<T> listEntriesBySort(Long lastEntryIndex, Integer entrySizePerPage);

    /**
     * 获取上一页最后一条数据的索引
     * 
     * @param dataOfLastEntry 上一页最后条目的数据
     * @return 上一页最后一条数据的索引
     */
    protected abstract Long getLastEntryIndex(T dataOfLastEntry);
}
