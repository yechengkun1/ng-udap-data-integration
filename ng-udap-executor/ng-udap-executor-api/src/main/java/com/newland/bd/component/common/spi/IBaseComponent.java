package com.newland.bd.component.common.spi;

import com.newland.bd.component.common.exception.ComponentException;
import com.newland.bd.component.common.ext.metrics.IComponentBusinessMetricsCollector;
import org.apache.commons.configuration2.Configuration;

/**
 * 组件接口定义
 * 调用顺序 setComponentConf---》prepareCheck--》prepare--》run--》destroy
 */
public interface IBaseComponent {
    /**
     * 设置组件配置信息.主要是前台配置的相关业务参数
     */
    void setComponentConf(ComponentRuntimeContext context, Configuration conf) throws ComponentException;

    /**
     * 对组件的校验参数进行校验.此方法先于prepare执行.
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
