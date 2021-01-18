package com.newland.bd.component.common.tuple.batch;

import com.newland.bd.component.common.tuple.Column;
import com.newland.bd.component.common.tuple.DataTuple;
import com.newland.bd.component.common.tuple.RecordTuple;
import com.newland.bd.component.common.tuple.format.ITupleFormat;
import com.newland.bd.component.common.tuple.record.IRecord;

import java.util.List;

/**
 * 一个BatchData中记录的集合。
 * User: YECK
 *
 */
public interface TupleWriter {

    /**
     * @return 获取这个记录里的格式定义
     */
    void setSchema(ITupleFormat format);

    /**
     * 输出一个Record对象
     *
     * @return
     */
    void emit(RecordTuple record);

    /**
     * 输出一个文本记录
     *
     * @return
     */
    void emit(String record);

    /**
     * 输出一个结构化记录
     *
     * @param record
     */
    void emit(List<Column> record);

    /**
     * 输出一个二进制记录
     *
     * @param record
     */
    void emit(byte[] record);

    /**
     * 写入完毕.
     */
    void close();
}