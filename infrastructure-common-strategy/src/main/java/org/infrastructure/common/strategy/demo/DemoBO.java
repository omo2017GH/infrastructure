/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

/**  
 * <b>ClassName:</b> org.infrastructure.common.strategy.demo.DemoBO.java <br>  
 * <b>Description:</b> (用一句话介绍类的作用) <br> 
 * <b>Date:</b> 2018年9月27日 下午6:42:09 <br>  
 * @author zhihong.he <br>
 * @version 1.0 
 */
public class DemoBO extends BaseStrategyBO implements IDemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1817589632204059957L;

    private Long id;
    private String code;

    /**
     * @return
     * @see org.infrastructure.common.strategy.demo.IDemoBO#getId()
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @return
     * @see org.infrastructure.common.strategy.demo.IDemoBO#getCode()
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
