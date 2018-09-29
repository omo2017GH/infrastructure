/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.core.Jstrategy;

/**
 * 客户端侧，策略模式接口实现示例
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class DemoBOJstrategyImpl implements Jstrategy<IdemoBO, Boolean> {

    @Override
    public Boolean apply(IdemoBO t) {
        System.out.println("IdemoBO = " + t);
        return true;
    }
}
