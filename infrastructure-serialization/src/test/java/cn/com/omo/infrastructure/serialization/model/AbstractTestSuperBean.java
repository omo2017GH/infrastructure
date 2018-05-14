package cn.com.omo.infrastructure.serialization.model;

import java.io.Serializable;

import cn.com.omo.infrastructure.serialization.anno.SeriesInfo;

/**
 *
 * @date 2018年1月2日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public abstract class AbstractTestSuperBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public int supBeanF1 = 1;

    @SeriesInfo(pos = -1)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
