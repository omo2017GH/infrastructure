/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.extension;

/**
 * 尾部指令抽象类
 * @date 2018年5月3日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
abstract class AbstractTailCommandContext extends AbstractLinkedCommandContext {

    static final String TAIL_NAME = "TAIL";
    static final int TAIL_ORDER = LOWEST_PRECEDENCE;

    AbstractTailCommandContext() {
        super(TAIL_NAME, TAIL_ORDER, TAIL_ORDER);
    }
}
