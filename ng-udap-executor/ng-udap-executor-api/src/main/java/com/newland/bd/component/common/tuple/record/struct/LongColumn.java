package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.tuple.Column;

/**
 * Created with IntelliJ IDEA.
 * User: YECK
 * Date: 2019/11/14
 */
public class LongColumn implements Column {

    private Long value;

    public LongColumn(String column) {
        this.value = (column == null || column.isEmpty()) ? null : Long.parseLong(column);
    }

    public LongColumn(long column) {
        this.value = column;
    }

    @Override
    public String asString() {
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public Long getValue() {
        return value;
    }
}