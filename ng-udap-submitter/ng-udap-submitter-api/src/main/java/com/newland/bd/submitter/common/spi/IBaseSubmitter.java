package com.newland.bd.submitter.common.spi;

import com.newland.bd.submitter.common.exception.SubmitterException;
import org.apache.commons.configuration2.Configuration;

/**
 * 提交器接口定义
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
     * 关闭提交器. 主要是对连接资源的销毁
     */
    void destroy() throws SubmitterException;

}
