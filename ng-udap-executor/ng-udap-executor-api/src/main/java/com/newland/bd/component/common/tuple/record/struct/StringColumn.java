package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.tuple.Column;

/**
 * Created with IntelliJ IDEA.
 * User: YECK
 * Date: 2019/11/14
 */
public class StringColumn implements Column {

    private String value;

    public StringColumn(String column) {
        this.value = (column == null || column.isEmpty()) ? "" : column;
    }

    @Override
    public String asString() {
        return value;
    }

    @Override
    public Object getValue() {
        return value;
    }


}