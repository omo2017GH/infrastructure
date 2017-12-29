package cn.com.omo.infrastructure.comparison;

import java.util.Comparator;

import org.springframework.core.Ordered;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class CommonComparatorFactory {

    public static final Comparator<Ordered> getHighPrecedenceComparator() {
        return ComparatorHolder.COMMON_1;
    }

    public static final Comparator<Ordered> getLowPrecedenceComparator() {
        return ComparatorHolder.COMMON_2;
    }

    private static class ComparatorHolder {

        private static final Comparator<Ordered> COMMON_1 = new Comparator<Ordered>() {
            @Override
            public int compare(Ordered o1, Ordered o2) {
                return o1.getOrder() - o2.getOrder();
            }
        };

        private static final Comparator<Ordered> COMMON_2 = new Comparator<Ordered>() {
            @Override
            public int compare(Ordered o1, Ordered o2) {
                return o2.getOrder() - o1.getOrder();
            }
        };
    }
}
