/**
 * Copyright: Copyright (c) 2018
 * Company: www.91wutong.com
 */

package cn.com.omo.infrastructure.common.model.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @date 2018年3月2日
 * 
 * @author zhihong.he
 * @version
 * @since 0.0.1-SNAPSHOT
 */
public abstract class BaseJavaBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1420178419171866865L;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
