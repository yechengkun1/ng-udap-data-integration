package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.tuple.Column;
import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.RecordType;

import java.util.List;

/**
 * 结构化的记录对象
 * User: YECK
 * Date: 2021/1/18
 */
public class StructRecord implements IRecord {

    private List<Column> columns;

    public StructRecord(List<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "StructRecordTuple{" + " ' columns=" + columns + '}';
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.STRUCT;
    }
}