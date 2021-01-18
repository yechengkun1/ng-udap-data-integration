package com.newland.bd.component.common.tuple.batch;

import com.newland.bd.component.common.tuple.DataTuple;
import com.newland.bd.component.common.tuple.format.ITupleFormat;

/**
 * 一个BatchData中记录的集合。
 * User: YECK
 *
 */
public interface TupleReader {

    /**
     * @return 获取这个记录里的格式定义
     */
    ITupleFormat getSchema();

    /**
     * 获取下一行记录
     *
     * @return
     */
    DataTuple next();

    /**
     * 读取完毕.
     */
    void close();
}