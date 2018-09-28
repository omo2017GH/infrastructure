/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

/**
 * 基于策略模式的业务服务示例
 * 
 * @date 2018年9月28日
 * 
 * @author zhihong.he
 * @version 0.1.0
 */
public class DemoBizService implements IDemoBizService {

    /**
     * @param bo
     * @see org.infrastructure.common.strategy.demo.IDemoBizService#go(org.infrastructure.common.strategy.demo.IDemoBO)
     */
    @Override
    public void go(IDemoBO bo) {
        bo.execute();
    }

}
