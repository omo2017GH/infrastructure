/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy.core;

import java.util.function.Function;

/**
 * 策略模式
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public interface Jstrategy<T, R> extends Function<T, R> {

    /**
     * 实施策略
     * @see java.util.function.Function#apply(java.lang.Object)
     */
    @Override
    R apply(T t);
}
