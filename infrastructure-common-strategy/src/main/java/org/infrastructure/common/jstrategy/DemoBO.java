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
public class DemoBO extends BaseDemoBO implements IdemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3577217878672410413L;

    private Long id;
    private String code;

    /* (non-Javadoc)
     * @see org.infrastructure.common.jstrategy.IdemoBO#getId()
     */
    @Override
    public Long getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see org.infrastructure.common.jstrategy.IdemoBO#getCode()
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

}
