package com.newland.bd.component.common.tuple.record.bytes;

import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.RecordType;

/**
 * 二进制消息对象
 * User: YECK
 * Date: 2021/1/18
 */
public class ByteRecord implements IRecord {
    private byte[] bytes;

    @Override
    public String toString() {
        return "RecordTuple{" + "bytes 长度'" + bytes.length + '\'' + '}';
    }

    public ByteRecord(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.BYTES;
    }
}