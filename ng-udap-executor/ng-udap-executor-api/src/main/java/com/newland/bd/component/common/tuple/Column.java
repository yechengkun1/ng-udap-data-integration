package com.newland.bd.component.common.tuple;

/**
 * 字段属性值
 * User: YECK
 * Date: 2019/11/13
 */
public interface Column {

    /**
     * 获取String
     */
    public String asString();

    /**
     * 获取这个字段真实的对象. 可以是long,String,double,Date
     *
     * @return
     */
    public Object getValue();
}