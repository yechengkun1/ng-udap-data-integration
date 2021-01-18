package com.newland.bd.component.common.tuple;

import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.RecordType;
import com.newland.bd.component.common.tuple.record.bytes.ByteRecord;
import com.newland.bd.component.common.tuple.record.string.StringRecord;
import com.newland.bd.component.common.tuple.record.struct.StructRecord;

import java.util.List;

/**
 * 数据记录tuple
 * //内部支持三种数据格式.
 * 这个对象是一个不可变对象.
 * User: YECK
 */
public class RecordTuple implements DataTuple {

    //原始记录对象
    private IRecord orgRecord;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecordTuple{");
        sb.append("orgRecord=").append(orgRecord);
        sb.append('}');
        return sb.toString();
    }

    public RecordTuple(byte[] bytes) {
        this.orgRecord = new ByteRecord(bytes);
    }

    public RecordTuple(String str) {
        this.orgRecord = new StringRecord(str);
    }

    public RecordTuple(List<Column> columns) {
        this.orgRecord = new StructRecord(columns);
    }

    public IRecord getOrgRecord() {
        return this.orgRecord;
    }

    public String getString() {
        return orgRecord.getRecordType() == RecordType.STRING ? ((StringRecord) orgRecord).getOrgRecord() : null;
    }

    public List<Column> getColumns() {
        return orgRecord.getRecordType() == RecordType.STRUCT ? ((StructRecord) orgRecord).getColumns() : null;
    }

    @Override
    public Column getColumn(int index) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public Column getColumn(String fieldName) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public byte[] getBytes() {
        return orgRecord.getRecordType() == RecordType.BYTES ? ((ByteRecord) orgRecord).getBytes() : null;
    }
}
