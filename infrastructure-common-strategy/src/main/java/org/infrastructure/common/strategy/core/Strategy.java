/**
* Copyright: Copyright (c) 2018
*/
package org.infrastructure.common.strategy.core;

/**
 * 策略模式接口类，此类负责策略的实施
 * @date 2018年9月25日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface Strategy {

    /**
     * 实施策略
     * @param target 执行对象
     */
    void execute(Object target);

}
