package com.newland.bd.component.common.ext.collector;

/**
 * 输出脏数据. 比如被过滤的数据，转换错误的数据等
 */
public interface WrongDataCollector {

    /**
     * 输出错误数据
     * @param dirtyRecord  错误数据内容
     * @param message   错误原因
     */
    void write(String dirtyRecord, String message);

    /**
     *
     * @param dirtyRecord 错误数据内容
     * @param message  错误原因
     * @param e  错误异常
     */
    void write(String dirtyRecord, String message, Exception e);
}
