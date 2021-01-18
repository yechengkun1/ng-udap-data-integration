package com.newland.bd.submitter.common.spi;

import com.newland.bd.submitter.common.exception.SubmitterException;
import com.newland.bd.submitter.common.ext.metrics.ISubmitterBusinessMetricsCollector;
import com.newland.bd.submitter.common.model.TaskResult;
import org.apache.commons.configuration2.Configuration;

/**
 * 提交器接口定义
 * 调用顺序 setTaskConf--》setSubmitterConf---》init--》prepareCheck--》prepare--》before-clean--》run--》complete()--》destroy
 */
public interface IBaseSubmitter {

    /**
     * 设置提交器配置信息.主要是前台配置的相关业务参数
     */
    void setSubmitterConf(SubmitterRuntimeContext runtimeContext, Configuration conf) throws SubmitterException;

    /**
     * 校验提交器参数
     */
    void prepareCheck() throws SubmitterException;

    /**
     * 执行前的预处理.如加载缓存、创建连接,目标写入前的清理动作等
     */
    void prepare() throws SubmitterException;



    /**
     * 触发提交器运行
     */
    TaskResult run() throws SubmitterException;

    /**
     * 只有在执行器执行成功时才会调用，做成功后的动作
     */
    boolean complete() throws SubmitterException;

    /**
     * 关闭提交器. 主要是对连接资源的销毁
     */
    void destroy() throws SubmitterException;

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
