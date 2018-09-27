/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/
package org.infrastructure.common.strategy.demo;

import org.infrastructure.common.strategy.core.StrategyContext;

/**  
 * <b>ClassName:</b> org.infrastructure.common.strategy.demo.IDemoBO.java <br>  
 * <b>Description:</b> (用一句话介绍类的作用) <br> 
 * <b>Date:</b> 2018年9月27日 下午6:31:22 <br>  
 * @author zhihong.he <br>
 * @version 1.0 
 */
public interface IDemoBO extends StrategyContext {

    Long getId();
    String getCode();
}
