package cn.com.omo.infrastructure.comparison.core;

import java.util.Comparator;

import org.springframework.core.Ordered;

import cn.com.omo.infrastructure.comparison.CommonComparatorFactory;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class CommonSorter extends AbstractSorter {

    /**
     * @see cn.com.omo.infrastructure.comparison.core.AbstractSorter#getComparator()
     */
    @Override
    protected Comparator<Ordered> getComparator() {
        return CommonComparatorFactory.getHighPrecedenceComparator();
    }

    /**
     * @see cn.com.omo.infrastructure.comparison.core.AbstractSorter#getDescComparator()
     */
    @Override
    protected Comparator<Ordered> getDescComparator() {
        return CommonComparatorFactory.getLowPrecedenceComparator();
    }

}
