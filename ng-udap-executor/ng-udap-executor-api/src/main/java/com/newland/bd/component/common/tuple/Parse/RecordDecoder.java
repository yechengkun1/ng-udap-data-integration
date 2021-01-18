package com.newland.bd.component.common.tuple.parse;

import com.newland.bd.component.common.tuple.format.ITupleFormat;
import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.bytes.ByteRecord;
import com.newland.bd.component.common.tuple.record.string.StringRecord;
import com.newland.bd.component.common.tuple.record.struct.StructRecord;

/**
 * 数据编解码.能适配数据格式不一致的问题
 * 框架提供标准的转换实现.  组件可以扩展自己特殊的转换逻辑
 * User: YECK
 * Date: 2021/01/18
 */
public interface RecordDecoder {

    //获取字段定义信息. 包含字段index，数据类型，字段name
    ITupleFormat getFieldsMeta();

    //获取一行String格式的记录
    StringRecord convertToString(IRecord record);

    //获取一行结构化对象的记录
    StructRecord convertToStruct(IRecord record);

    //获取二进制数据
    ByteRecord convertToBytes(IRecord record);
}