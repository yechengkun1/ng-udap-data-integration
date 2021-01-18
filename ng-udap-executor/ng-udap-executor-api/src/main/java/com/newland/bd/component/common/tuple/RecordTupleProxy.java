package com.newland.bd.component.common.tuple;

import com.newland.bd.component.common.tuple.parse.RecordDecoder;
import com.newland.bd.component.common.tuple.record.struct.StructRecord;

import java.util.List;

/**
 * 数据记录tuple的代理类.暴露给下游组件内部使用.
 * 下游组件根据需要，获取字符串，Column或bytes.
 * 平台会根据decoder进行格式转换，当出现不兼容的转换对象时，会抛出不支持的异常
 * User: YECK
 * Date: 2019/10/24
 */
public class RecordTupleProxy implements DataTuple {

    private RecordTuple tuple;
    private final RecordDecoder decoder;
    private StructRecord resultStructRecord;   //结构化的对象会被多次使用到，需要缓存结果

    public RecordTupleProxy(RecordTuple tuple, RecordDecoder decoder) {
        this.decoder = decoder;
        this.tuple = tuple;
    }

    public RecordTupleProxy(RecordDecoder decoder) {
        this.decoder = decoder;
    }

    public void setTuple(RecordTuple tuple) {
        this.tuple = tuple;
    }

    /**
     * 获取一行String格式的记录
     *
     * @return
     */
    public String getString() {
        //decoder的判断和转码逻辑
        return decoder.convertToString(tuple.getOrgRecord()).getOrgRecord();
    }

    /**
     * 获取一行记录的字段列表
     *
     * @return
     */
    public List<Column> getColumns() {
        if (resultStructRecord == null) {
            //decoder的判断和转码逻辑
            resultStructRecord = decoder.convertToStruct(tuple.getOrgRecord());
        }
        return resultStructRecord.getColumns();
    }

    /**
     * 获取某个字段值
     *
     * @param index
     * @return
     */
    @Override
    public Column getColumn(int index) {
        return getColumns().get(index);
    }

    /**
     * 获取某个字段值
     *
     * @param fieldCode
     * @return
     */
    @Override
    public Column getColumn(String fieldCode) {
        int index = decoder.getFieldsMeta().getFieldIndexByCode(fieldCode);
        return getColumn(index);
    }

    /**
     * 获取二进制消息
     *
     * @return
     */
    @Override
    public byte[] getBytes() {
        return decoder.convertToBytes(tuple.getOrgRecord()).getBytes();
    }
}