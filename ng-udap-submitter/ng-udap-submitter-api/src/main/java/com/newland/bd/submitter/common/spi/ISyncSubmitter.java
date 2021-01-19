package com.newland.bd.submitter.common.spi;

import com.newland.bd.submitter.common.exception.SubmitterException;
import com.newland.bd.submitter.common.ext.metrics.ISubmitterBusinessMetricsCollector;
import com.newland.bd.submitter.common.model.TaskResult;
import org.apache.commons.configuration2.Configuration;

/**
 * 同步提交器，执行动作必须等待立刻返回的提交器，用于类似sql提交，文件操作等
 * 同步调用顺序 setSubmitterConf---》init--》prepareCheck--》prepare--》before-clean--》run--》complete()--》destroy
 */
public interface ISyncSubmitter {

    /**
     * 触发提交器执行
     */
    TaskResult run() throws SubmitterException;

    /**
     * 定义指标收集对象
     *
     * @return
     */
    ISubmitterBusinessMetricsCollector getMetricsCollector();

    /**
     * 触发提交器中止运行命令
     */
    boolean interrupt() throws SubmitterException;
}
