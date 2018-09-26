/**
 * Copyright: Copyright (c) 2018 Company: www.91wutong.com
 */
package cn.com.omo.infrastructure.common.util.conversion;

import java.util.function.BiConsumer;

/**
 * <b>ClassName:</b> com.wt.cts.common.util.UnaryConversionTemplate.java <br>
 * <b>Description:</b> (用一句话介绍类的作用) <br>
 * <b>Date:</b> 2018年8月20日 下午4:32:58 <br>
 * 
 * @author zhihong.he <br>
 * @version 1.0
 */
public class UnaryConversionTemplate<U> extends ConversionTemplate<U, U> {

    @Override
    public void convertGenericType(U source, U target, BiConsumer<U, U> convertor) {
        super.convertGenericType(source, target, convertor);
    }
}
