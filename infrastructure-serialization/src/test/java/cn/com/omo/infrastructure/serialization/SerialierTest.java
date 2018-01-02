/**
 * 
 * 汇付天下
 * Copyright (c) 2017-2020 ChinaPnR,Inc.All Rights Reserved.
 *
 */
package cn.com.omo.infrastructure.serialization;

import java.math.BigDecimal;

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

        TestBeanSerializer serializer = new TestBeanSerializer();
        String s = serializer.serialize(bean);
        System.out.println(s);
        System.out.println(serializer.deserialize(s, TestBean.class));
    }
}
