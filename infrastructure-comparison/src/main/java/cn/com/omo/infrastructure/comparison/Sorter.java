/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.comparison;

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
public interface Sorter {

    /**
     * 升序排序
     */
    void sort(List<? extends Ordered> list);

    /**
     * 降序排序
     */
    void sortByDesc(List<? extends Ordered> list);
}
