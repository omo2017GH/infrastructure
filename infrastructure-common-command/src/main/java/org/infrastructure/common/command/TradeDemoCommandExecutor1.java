/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command;

import org.infrastructure.common.command.extension.AbstractLinkedCommandContext;
import org.infrastructure.common.command.extension.AbstractCommandExecutor;
import org.springframework.stereotype.Service;

/**
 * TradeDemoCommandExecutor0
 * @date 2018年4月28日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
@Service("tradeDemoCommandExecutor1")
public class TradeDemoCommandExecutor1 extends AbstractCommandExecutor {

    @Override
    protected Integer run(AbstractLinkedCommandContext context) {
        System.out.println("========== name: " + context.getName() + ", bizObj: " + context.getObject());
        return null;
    }
}
