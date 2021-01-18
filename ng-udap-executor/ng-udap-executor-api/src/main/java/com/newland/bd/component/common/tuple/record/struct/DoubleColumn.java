package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.tuple.Column;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: YECK
 * Date: 2019/11/14
 */
public class DoubleColumn implements Column {
    //Double 类型在转字符串的时候会带上E,如：10002101-1.0002101E7
    private BigDecimal value;

    public DoubleColumn(String column) {
        this.value = (column == null || column.isEmpty()) ? null : new BigDecimal(column);
    }

    public DoubleColumn(long column) {
        this.value = new BigDecimal(column);
    }

    @Override
    public String asString() {
        return value == null ? "" : String.valueOf(value);
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }
}