package com.newland.bd.component.common.ext.metrics;

/**
 * \* 组件实例度量信息
 * \* User: YECK
 * \* Date: 2019/11/27
 * \
 */
public interface ITransformComponentMetricsCollector extends IComponentBusinessMetricsCollector {

    /**
     * 记录输出记录数
     *
     * @param n
     */
    public void addOutRecords(long n);

    /**
     * 记录过滤记录数
     *
     * @param n
     */
    public void addFilterRecords(long n);

    /**
     * 记录错误记录数
     *
     * @param n
     */
    public void addErrorRecords(long n);

    /**
     * 获取已累计的Records
     */
    public long getOutRecords();
}
