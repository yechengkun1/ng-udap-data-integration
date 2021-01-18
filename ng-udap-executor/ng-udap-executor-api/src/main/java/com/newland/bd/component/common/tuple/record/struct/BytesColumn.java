package com.newland.bd.component.common.tuple.record.struct;

import com.newland.bd.component.common.exception.ComponentCommonError;
import com.newland.bd.component.common.exception.ComponentException;
import com.newland.bd.component.common.tuple.Column;

/**
 * 二进制字段
 * User: YECK
 * Date: 2019/11/14
 */
public class BytesColumn implements Column {
    private byte[] values;

    public BytesColumn(byte[] column) {
        this.values = column;
    }

    @Override
    public String asString() {
        throw new ComponentException(ComponentCommonError.C_COMMON_00001, "出现运行时异常,不支持bytesColumn转String.");
    }

    @Override
    public Object getValue() {
        return values;
    }
}