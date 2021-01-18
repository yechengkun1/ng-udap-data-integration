package com.newland.bd.component.common.spi;

import com.newland.bd.component.common.ext.collector.WrongDataCollector;
import com.newland.bd.component.common.ext.event.IEventSender;
import com.newland.bd.component.common.ext.resource.IConnectionConfing;
import com.newland.bd.component.common.ext.var.IVarParser;
import com.newland.bd.component.common.model.ComponentInstanceInfo;

/**
 * 通过它可以访问到当前插件运行的上下文信息.
 * 主要信息包括：
 * 本身的参数信息，上下游插件信息，连接获取工具，事件发送工具，脏数据工具
 * User: YECK
 * Date: 2021/1/12
 */
public interface ComponentRuntimeContext {

    /**
     * 返回这个插件并行子实例的信息
     *
     * @return
     */
    ComponentInstanceInfo getInstanceInfo();

    /**
     * 获取连接查询对象
     *
     * @return
     */
    IConnectionConfing getConnectionConfig();

    /**
     * 获取事件发送接口
     *
     * @return
     */
    IEventSender getEventSender();

    /**
     * 获取脏数据发送对象
     *
     * @return 获取脏数据发送对象
     */
    WrongDataCollector getWrongDFataCollector();

    /**
     * 获取变量转换接口. 这部分还没细化
     *
     * @return
     */
    IVarParser getVarParser();
}