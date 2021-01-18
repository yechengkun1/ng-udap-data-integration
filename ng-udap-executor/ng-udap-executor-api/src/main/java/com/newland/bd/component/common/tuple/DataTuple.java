package com.newland.bd.component.common.tuple;

import java.util.List;

/**
 * 数据tuple
 * User: YECK
 * Date: 2019/10/24
 */
public interface DataTuple extends Tuple {

    //获取一行String格式的记录
    public String getString();

    //获取一行结构化对象的记录 获取字段信息.
    public List<Column> getColumns();

    //获取某个列值.下标从0开始
    public Column getColumn(int index);

    //获取某个列值,按字段code获取
    public Column getColumn(String fieldCode);

    //获取这行记录的二进制字节
    public byte[] getBytes();
}