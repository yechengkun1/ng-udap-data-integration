package com.newland.bd.submitter.common.spi;

import com.newland.bd.resources.interfaces.IResourcesConfig;
import com.newland.bd.submitter.common.ext.event.IEventSender;
import com.newland.bd.submitter.common.ext.state.ISubmitterStatefuleStorage;
import com.newland.bd.submitter.common.model.SubmitterInstanceInfo;

/**
 * 通过它可以访问到当前插件运行的上下文信息.
 * 主要信息包括：
 * 本身的参数信息，上下游插件信息，连接获取工具，事件发送工具，脏数据工具
 * User: YECK
 * Date: 2021/1/12
 */
public interface SubmitterRuntimeContext {

    /**
     * 返回这个插件并行子实例的信息
     *
     * @return
     */
    SubmitterInstanceInfo getInstanceInfo();

    /**
     * 获取连接查询对象
     *
     * @return
     */
    IResourcesConfig getConnectionConfig();

    /**
     * 获取事件发送接口
     *
     * @return
     */
    IEventSender getEventSender();

    /**
     * 获取提交器状态保存接口
     *
     * @return
     */
    ISubmitterStatefuleStorage getStateStorage();
}