package cn.com.omo.infrastructure.serialization.model;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.serialization.anno.SeriesInfo;

/**
 *
 * @date 2018年1月2日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class TestBean extends TestSuperBean {

    /**
     * 
     */
    private static final long serialVersionUID = 2768363950219384605L;
    @SeriesInfo(pos = 1)
    private String code;
    @SeriesInfo(pos = 2)
    private boolean del;
    @SeriesInfo(pos = 3)
    private BigDecimal num;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public boolean isDel() {
        return del;
    }
    public void setDel(boolean del) {
        this.del = del;
    }
    public BigDecimal getNum() {
        return num;
    }
    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
