package cn.com.omo.infrastructure.comparison;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.core.Ordered;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractSorter implements Sorter {

    /**
     * @see cn.com.omo.infrastructure.comparison.Sorter#sort(java.util.List)
     */
    @Override
    public void sort(List<? extends Ordered> list) {
        Collections.sort(list, getComparator());
    }

    /**
     * @see cn.com.omo.infrastructure.comparison.Sorter#sortByDesc(java.util.List)
     */
    @Override
    public void sortByDesc(List<? extends Ordered> list) {
        Collections.sort(list, getDescComparator());
    }

    protected abstract Comparator<Ordered> getComparator();
    protected abstract Comparator<Ordered> getDescComparator();
}
