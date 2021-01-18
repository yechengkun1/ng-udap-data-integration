package com.newland.bd.submitter.common.ext.metrics.control;

import com.newland.bd.submitter.common.ext.metrics.ISubmitterBusinessMetricsCollector;

/**
 * \* 提交器实例度量信息
 * \* User: YECK
 * \
 */
public interface IControlSubmitterMetricsCollector extends ISubmitterBusinessMetricsCollector {
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
     * 记录输出字节数
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
}
