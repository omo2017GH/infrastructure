/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.validation.jsr303.core.item;

import java.math.BigDecimal;

/**
 *
 * @date 2017年12月8日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class JvalidationItemFactory {

    public JvalidationItemFactory() {}

    public static BooleanJvalidationItem buildBooleanJvalidationItem(Boolean itemValue, String message) {
        return new BooleanJvalidationItem(itemValue, message);
    }
    
    public static DecimalMaxJvalidationItem buildDecimalMaxJvalidationItem(BigDecimal itemValue, boolean inclusive, String message) {
        return new DecimalMaxJvalidationItem(itemValue, inclusive, message);
    }
    
    public static DecimalMinJvalidationItem buildDecimalMinJvalidationItem(BigDecimal itemValue, boolean inclusive, String message) {
        return new DecimalMinJvalidationItem(itemValue, inclusive, message);
    }
    
    public static DigitsJvalidationItem buildDigitsJvalidationItem(BigDecimal itemValue, String message) {
        return new DigitsJvalidationItem(itemValue, message);
    }
    
    public static FutureJvalidationItem buildFutureJvalidationItem(String message) {
        return new FutureJvalidationItem(message);
    }
    
    public static PastJvalidationItem buildPastJvalidationItem(String message) {
        return new PastJvalidationItem(message);
    }
    
    public static MaxJvalidationItem buildMaxJvalidationItem(BigDecimal itemValue, String message) {
        return new MaxJvalidationItem(itemValue, message);
    }
    
    public static MinJvalidationItem buildMinJvalidationItem(BigDecimal itemValue, String message) {
        return new MinJvalidationItem(itemValue, message);
    }
    
    public static NullOrNotJvalidationItem buildNullOrNotJvalidationItem(Boolean itemValue, String message) {
        return new NullOrNotJvalidationItem(itemValue, message);
    }
    
    public static PatternJvalidationItem buildPatternJvalidationItem(String itemValue, String message) {
        return new PatternJvalidationItem(itemValue, message);
    }
    
    public static SizeJvalidationItem buildSizeJvalidationItem(String itemValue, String message) {
        return new SizeJvalidationItem(itemValue, message);
    }
}
