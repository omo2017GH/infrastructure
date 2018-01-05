package cn.com.omo.infrastructure.serialization;

import java.math.BigDecimal;

import cn.com.omo.infrastructure.serialization.core.Serializer;
import cn.com.omo.infrastructure.serialization.core.SimpleBeanSerializer;
import cn.com.omo.infrastructure.serialization.model.TestBean;

/**
 *
 * @date 2018年1月2日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class SerialierTest {

    public static void main(String[] args) {
        TestBean bean = new TestBean();
        bean.setId("id1");
        bean.setCode("001");
        bean.setDel(true);
        bean.setNum(BigDecimal.ONE);

//        Serializer serializer = new TestBeanSerializer();
        Serializer serializer = new SimpleBeanSerializer();
        String s = serializer.serialize(bean);
        System.out.println(s);
        System.out.println(serializer.deserialize(s, TestBean.class));
    }
}
