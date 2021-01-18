package com.newland.bd.component.common.ext.metrics;

/**
 * \* 组件实例度量信息
 * \* User: YECK
 * \* Date: 2019/11/27
 * \
 */
public interface ISinkComponentMetricsCollector extends IComponentBusinessMetricsCollector {

    /**
     * 记录输出记录数
     *
     * @param n
     */
    public void addOutRecords(long n);

    /**
     * 记录输入字节数
     *
     * @param n
     */
    public void addOutBytes(long n);

    /**
     * 记录输入文件数
     *
     * @param n
     */
    public void addOutFiles(int n);

    /**
     * 获取已累计的Records
     */
    public long getOutRecords();
}
