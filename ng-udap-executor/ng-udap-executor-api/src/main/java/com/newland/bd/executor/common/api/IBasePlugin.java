package com.newland.bd.executor.common.api;

import com.newland.bd.executor.common.api.exception.ComponentException;

import javax.security.auth.login.Configuration;

/**
 * \* 执行器插件的基类
 * \* User: YECK
 * \* Date: 2021/1/12
 * \
 */
public interface IBasePlugin {
    /**
     * 设置任务运行属性. 信息包括TASK_CONF_KEY_开头定义的key内容
     *
     * @param conf
     * @throws ComponentException
     */
    void setConf(Configuration taskConf,Configuration conf) throws ComponentException;


    /**
     * 设置资源获取client.用来获取连接配置信息
     */

    void setEnvClient(IResourcesConfig envClient) throws ComponentException;

    /**
     * 获取组件实例的信息
     */
    ComponentInstanceInfo getComponentInstanceInfo();

    /**
     * 校验组件参数
     */
    void prepareCheck() throws ComponentException;

    /**
     * 执行前的预处理.如加载缓存、创建连接,目标写入前的清理动作等
     */
    void prepare() throws ComponentException;

    /**
     * 关闭组件. 主要是对连接资源的销毁
     */
    void destroy() throws ComponentException;

    /**
     * 定义指标收集对象
     *
     * @return
     */
    IComponentBusinessMetricsCollector getMetricsCollector();
}
