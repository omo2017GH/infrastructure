/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.command.extension;

/**
 * 头部指令抽象类
 * @date 2018年5月3日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.2-SNAPSHOT
 */
abstract class AbstractHeadCommandContext extends AbstractLinkedCommandContext {

    static final String HEAD_NAME = "HEAD";
    static final int HEAD_ORDER = HIGHEST_PRECEDENCE;

    AbstractHeadCommandContext(int headResult) {
        super(HEAD_NAME, HEAD_ORDER, headResult);
    }

}
