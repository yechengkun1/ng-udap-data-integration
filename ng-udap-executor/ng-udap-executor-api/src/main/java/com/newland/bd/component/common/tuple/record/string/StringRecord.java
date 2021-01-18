package com.newland.bd.component.common.tuple.record.string;

import com.newland.bd.component.common.tuple.record.IRecord;
import com.newland.bd.component.common.tuple.record.RecordType;

/**
 * 字符串记录对象
 * User: YECK
 *
 */
public class StringRecord implements IRecord {

    private String orgRecord;

    @Override
    public String toString() {
        return "RecordTuple{" + "orgRecord='" + orgRecord + '\'' + '}';
    }

    public StringRecord(String orgRecord) {
        this.orgRecord = orgRecord;
    }

    public String getOrgRecord() {
        return orgRecord;
    }

    @Override
    public RecordType getRecordType() {
        return RecordType.STRING;
    }
}