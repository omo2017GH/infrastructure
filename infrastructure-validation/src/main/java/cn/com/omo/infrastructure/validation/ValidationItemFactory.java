/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.com.omo.infrastructure.validation.core.item.BlankValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.DateValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.EmptyValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.EquivalenceValidationItem;
import cn.com.omo.infrastructure.validation.core.item.InequivalenceValidationItem;
import cn.com.omo.infrastructure.validation.core.item.MaxLenthValidationItem;
import cn.com.omo.infrastructure.validation.core.item.MaxValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.MinLenthValidationItem;
import cn.com.omo.infrastructure.validation.core.item.MinValueValidationItem;
import cn.com.omo.infrastructure.validation.core.item.NullValidationItem;
import cn.com.omo.infrastructure.validation.core.item.ValidationItem;

/**
 *
 * @date 2017年11月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class ValidationItemFactory {

    private static final int ITEMS_CAPACITY = 20;

    private List<ValidationItem> items = new ArrayList<ValidationItem>(ITEMS_CAPACITY);

    private Set<Class<? extends ValidationItem>> validationItemClazzSet = new HashSet<Class<? extends ValidationItem>>(ITEMS_CAPACITY);

//    private static final List<Class<?>> WHITE_LIST = Arrays.asList(new Class<?>[] { EquivalenceValidationItem.class, InequivalenceValidationItem.class });

    public ValidationItemFactory addValidationItem(ValidationItem item) {
        if (validationItemClazzSet.add(item.getClass())) {
            items.add(item);
        }
        return this;
    }

    public ValidationItemFactory addEmptyValueValidationItem(Boolean itemValue) {
        addValidationItem(new EmptyValueValidationItem(itemValue));
        return this;
    }
    
    public ValidationItemFactory addEquivalenceValidationItem(Object itemValue) {
        addValidationItem(new EquivalenceValidationItem(itemValue));
        return this;
    }
    
    public ValidationItemFactory addInequivalenceValidationItem(Object itemValue) {
        addValidationItem(new InequivalenceValidationItem(itemValue));
        return this;
    }
    
    public ValidationItemFactory addMaxLenthValidationItem(BigDecimal itemValue, boolean includeBound) {
        addValidationItem(new MaxLenthValidationItem(itemValue, includeBound));
        return this;
    }
    
    public ValidationItemFactory addMinLenthValidationItem(BigDecimal itemValue, boolean includeBound) {
        addValidationItem(new MinLenthValidationItem(itemValue, includeBound));
        return this;
    }
    
    public ValidationItemFactory addMaxValueValidationItem(BigDecimal itemValue, boolean includeBound) {
        addValidationItem(new MaxValueValidationItem(itemValue, includeBound));
        return this;
    }
    
    public ValidationItemFactory addMinValueValidationItem(BigDecimal itemValue, boolean includeBound) {
        addValidationItem(new MinValueValidationItem(itemValue, includeBound));
        return this;
    }
    
    public ValidationItemFactory addNullValidationItem(Boolean itemValue) {
        addValidationItem(new NullValidationItem(itemValue));
        return this;
    }

    public ValidationItemFactory addBlankValidationItem(Boolean itemValue) {
        addValidationItem(new BlankValueValidationItem(itemValue));
        return this;
    }
    
    public ValidationItemFactory addDateValidationItem(String itemValue) {
        addValidationItem(new DateValueValidationItem(itemValue));
        return this;
    }
    
    public List<ValidationItem> buildItems() {
        List<ValidationItem> list = new ArrayList<ValidationItem>(items);
        init();
        return list;
    }

    private void init() {
        items = new ArrayList<ValidationItem>(ITEMS_CAPACITY);
        validationItemClazzSet = new HashSet<Class<? extends ValidationItem>>(ITEMS_CAPACITY);
    }
}
