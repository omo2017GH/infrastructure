/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo.spring;

import org.infrastructure.common.strategy.demo.IDemoBO;

/**
 * 基于Spring策略模式的业务服务接口示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public interface IDemoSpingBizService {

    void go(IDemoBO bo);
}
