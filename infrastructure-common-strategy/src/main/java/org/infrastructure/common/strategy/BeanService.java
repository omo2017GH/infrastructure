/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.strategy;

import org.springframework.stereotype.Service;

/**
 * 
 * @date 2018年5月10日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
@Service("beanServiceDemo")
public class BeanService {

    public void test(BeanBO bo) {
        System.out.println(bo);
    }
}
