package com.newland.bd.submitter.common.ext.metrics.audit;

/**
 * 实现这个接口的指标,平台会在任务结束时对此记录结果进行审计
 * 不属于ETL过程的提交器,如清理类提交器指标不要实现这个接口.
 * User: YECK
 * Date: 2020/3/20
 */
public interface IMetricsAuditAble {

    /**
     * 获取提交器输入记录数
     */
    public long getInputRecords();

    /**
     * 获取输出记录数
     */
    public long getOutputRecords();

    /**
     * 获取提交器过滤记录数
     */
    public long getFilterRecords();

    /**
     * 获取错误记录数
     */
    public long getErrorRecords();
}