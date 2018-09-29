/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import org.infrastructure.common.jstrategy.core.Jstrategy;

import cn.com.omo.infrastructure.common.model.base.BaseJavaBean;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
@SuppressWarnings("unchecked")
public abstract class BaseDemoBO extends BaseJavaBean implements IdemoBO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Jstrategy<IdemoBO, Boolean> jstrategy;

    /* (non-Javadoc)
     * @see org.infrastructure.common.jstrategy.core.JstrategyContext#get()
     */
    @Override
    public IdemoBO get() {
        return this;
    }

    /* (non-Javadoc)
     * @see org.infrastructure.common.jstrategy.core.JstrategyContext#getStrategy()
     */
    @Override
    public Jstrategy<IdemoBO, Boolean> getStrategy() {
        return jstrategy;
    }

    /**
     * @return the jstrategy
     */
    public Jstrategy<IdemoBO, Boolean> getJstrategy() {
        return jstrategy;
    }

    /**
     * @param jstrategy the jstrategy to set
     */
    public void setJstrategy(Jstrategy<IdemoBO, Boolean> jstrategy) {
        this.jstrategy = jstrategy;
    }
}
