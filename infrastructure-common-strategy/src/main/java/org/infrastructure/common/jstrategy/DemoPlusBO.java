/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class DemoPlusBO extends DemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4878876691867223111L;

    public DemoPlusBO() {
        setJstrategy(new DemoBOJstrategyImpl());
    }
}
