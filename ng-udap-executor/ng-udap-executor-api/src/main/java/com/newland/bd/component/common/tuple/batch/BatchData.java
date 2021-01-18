package com.newland.bd.component.common.tuple.batch;

/**
 * 整个处理模型本质上是micro-batch，是以BatchData作为插件之间传输的数据最小对象.
 * 一个BatchData通常指代1个ftp文件、1批Kafka分区从start-offset到end-offset的记录集、或sql查询的某个结果集
 * 一个batchData最大可以是几K到几G级别.
 * <p>
 * 每个BatchData，都包含有：
 * id（数据块的唯一ID）， 源数据业务属性（如kafka的offset，ftp文件信息，hdfs文件块信息），格式描述（类型【二进制，结构化对象，文本】），schema（内容格式的详细描述，对应的序列化序列化对象）），值流stream（一块固定大小的内存通道）
 * <p>
 * 平台会以BatchData作为事务的最小单位，当发送断点续作时，会通知source插件复现最后一批未完成的BatchData数据.
 * <p>
 * BatchData都创建后，里面的对象就已经固定，下游的插件不能修改其中的属性.
 * User: YECK
 *
 */
public interface BatchData extends Comparable<BatchData> {
    /**
     * 一批数据的ID.
     */
    int getId();

    /**
     * 当source插件创建原始的BatchData，经过process组件后，生产新的BatchDat，则这个parentId就是原始BatchDataId
     *
     * @return
     */
    int getParentId();

    /**
     * 获取这批数据的业务属性.
     * 如所属的kafka的offset，ftp文件信息，hdfs文件块信息
     *
     * @return
     */
    BatchDataAttributes getAttributes();

    /**
     * 获取本批数据的读取对象
     *
     * @return
     */
    TupleReader getTupleReader();

    /**
     * 获取批数据的写入对象
     *
     * @return
     */
    TupleWriter getTupleWriter();
}