package com.newland.bd.component.common.tuple.format;

import com.newland.bd.component.common.exception.ComponentCommonError;
import com.newland.bd.component.common.exception.ComponentException;

import java.util.List;

/**
 * 数据同步场景下传输的标准数据
 * User: YECK
 * Date: 2019/9/11
 */
public class StringTupleFormat implements ITupleFormat {

    private List<FieldInfo> fields; //字段列信息定义
    private String fieldDelimiter; //字段分隔符

    /**
     * 构造函数
     *
     * @param fields         字段列表
     * @param fieldDelimiter 字段分隔符
     */
    public StringTupleFormat(List<FieldInfo> fields, String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
        this.fields = fields;
    }

    public String getFieldDelimiter() {
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    @Override
    public int getFieldIndexByCode(String fieldCode) {
        int index = 0;
        for (FieldInfo info : fields) {
            if (fieldCode.equals(info.getCode())) {
                return index;
            }
            index++;
        }
        throw new ComponentException(ComponentCommonError.C_COMMON_00001,
                                     String.format(ComponentCommonError.C_COMMON_00001.getMessage(), "字段" + fieldCode + "不在定义的字段列表中." + fields));
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringTupleFormat that = (StringTupleFormat) o;
        ;
        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;
        return fieldDelimiter != null ? fieldDelimiter.equals(that.fieldDelimiter) : that.fieldDelimiter == null;
    }

    @Override
    public int hashCode() {
        int result = fields != null ? fields.hashCode() : 0;
        result = 31 * result + (fieldDelimiter != null ? fieldDelimiter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StringTupleFormat{" + "fields=" + fields + ", fieldDelimiter='" + fieldDelimiter + '\'' + '}';
    }
}