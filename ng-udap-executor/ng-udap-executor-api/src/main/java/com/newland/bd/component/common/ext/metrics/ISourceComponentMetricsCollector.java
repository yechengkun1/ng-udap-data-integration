package com.newland.bd.component.common.ext.metrics;

/**
 * \* 组件实例度量信息
 * \* User: YECK
 * \* Date: 2019/11/27
 * \
 */
public interface ISourceComponentMetricsCollector extends IComponentBusinessMetricsCollector {
    /**
     * 记录输入字节数
     *
     * @param n
     */
    public void addInRecords(long n);

    /**
     * 记录输入字节数
     *
     * @param n
     */
    public void addInBytes(long n);

    /**
     * 记录输入文件数
     *
     * @param n
     */
    public void addInFiles(int n);

    /**
     * 获取已累计的Records
     */
    public long getInRecords();
}
