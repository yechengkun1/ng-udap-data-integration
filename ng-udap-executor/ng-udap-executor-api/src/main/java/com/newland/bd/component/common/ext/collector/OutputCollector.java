package com.newland.bd.component.common.ext.collector;

import com.newland.bd.component.common.spi.IAckCallBack;
import com.newland.bd.component.common.tuple.batch.BatchData;
import com.newland.bd.component.common.tuple.batch.BatchDataAttributes;
import com.newland.bd.component.common.tuple.format.ITupleFormat;
import com.newland.bd.component.common.tuple.record.RecordType;

/**
 * 发送数据对象
 * User: YECK
 * Date: 2021/1/18
 */
public interface OutputCollector {

    /**
     * 创建一个BatchData，组件往BatchData的TupleWriter里写入数据.
     * BatchData是一个逻辑上的批数据，表示一批有业务含义的tuple的集合，如一个文件.
     * 写往TupleWriter是立刻被下游读取，并不需要等待submit后下游才开始执行.
     *
     * @param attributes  业务属性信息. 如文件信息， 如kafka分区+offset信息
     * @param tupleFormat 数据的格式定义.
     * @param recordType  记录类型：二进制，文本，结构对象
     * @return
     */
    BatchData createBatch(BatchDataAttributes attributes, ITupleFormat tupleFormat, RecordType recordType);

    /**
     * 往BatchData的TupleWriter里完这批数据，提交
     *
     * @param data
     */
    void submit(BatchData data);

    /**
     * 往BatchData的TupleWriter里完这批数据，提交
     *
     * @param data
     * @param ackCallBack 当所有下游插件都处理完这批数据后，会执行此回调。 比如下游处理完这个文件数据后，调用此方法进行文件删除
     */
    void submit(BatchData data, IAckCallBack ackCallBack);
}