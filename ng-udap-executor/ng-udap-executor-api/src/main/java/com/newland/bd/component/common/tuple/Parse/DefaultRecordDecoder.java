package com.newland.bd.component.common.tuple.parse;

import com.newland.bd.component.common.tuple.format.ITupleFormat;
import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.bytes.ByteRecord;
import com.newland.bd.component.common.tuple.record.string.StringRecord;
import com.newland.bd.component.common.tuple.record.struct.StructRecord;


/**
 * 对原始消息按照其格式信息进行解码. 可以输出String格式和字段格式.
 * User: YECK
 * Date: 2021/01/18
 */
public class DefaultRecordDecoder implements RecordDecoder {
    private final ITupleFormat inputFormat;

    /**
     * 传入的数据格式信息
     *
     * @param inputFormat
     */
    public DefaultRecordDecoder(ITupleFormat inputFormat) {
        this.inputFormat = inputFormat;
    }

    @Override
    public ITupleFormat getFieldsMeta() {
        return this.inputFormat;
    }

    @Override
    public StringRecord convertToString(IRecord record) {
        return null;
    }

    @Override
    public StructRecord convertToStruct(IRecord record) {
        return null;
    }

    @Override
    public ByteRecord convertToBytes(IRecord record) {
        return null;
    }
}