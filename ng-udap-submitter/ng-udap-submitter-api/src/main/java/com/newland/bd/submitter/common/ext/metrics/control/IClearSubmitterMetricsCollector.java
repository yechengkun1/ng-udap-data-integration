package com.newland.bd.submitter.common.ext.metrics.control;

import com.newland.bd.submitter.common.ext.metrics.ISubmitterBusinessMetricsCollector;

/**
 * \* 清理类提交器指标.
 * \* User: YECK
 * \
 */
public interface IClearSubmitterMetricsCollector extends ISubmitterBusinessMetricsCollector {

    /**
     * 删除错误记录数
     *
     * @param n
     */
    public void addDeleteRecords(long n);

    /**
     * 删除字节数
     *
     * @param n
     */
    public void addDeleteBytes(long n);

    /**
     * 删除文件数
     *
     * @param n
     */
    public void addDeleteFiles(int n);
}
