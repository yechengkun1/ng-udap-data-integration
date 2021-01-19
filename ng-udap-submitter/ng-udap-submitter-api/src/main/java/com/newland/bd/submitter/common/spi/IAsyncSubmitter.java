package com.newland.bd.submitter.common.spi;

import com.newland.bd.submitter.common.exception.SubmitterException;
import com.newland.bd.submitter.common.ext.metrics.ISubmitterBusinessMetricsCollector;
import com.newland.bd.submitter.common.model.TaskResult;

/**
 * 异步提交器，用于常驻式任务的提交动作
 */
public interface IAsyncSubmitter {

    /**
     * 提交器提交
     */
    TaskResult submit() throws SubmitterException;

    /**
     * 对任务情况进行监控和检查，常用于常驻任务提交
     */
    TaskResult checkStatus() throws SubmitterException;

    /**
     * 获取指标收集对象
     *
     * @return
     */
    ISubmitterBusinessMetricsCollector getMetricsCollector();

    /**
     * 触发提交器中止运行命令
     */
    boolean interrupt() throws SubmitterException;
}
