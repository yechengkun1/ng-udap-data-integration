package com.newland.bd.component.common.spi.stream;

import com.newland.bd.component.common.ext.collector.OutputCollector;
import com.newland.bd.component.common.spi.IBatchComponent;
import com.newland.bd.component.common.tuple.batch.BatchData;

import java.util.Map;

/**
 * 预留接口，
 * 对数据做分发. 前台页面配置了N条输出规则，框架会构造N个ForkComponent的实例
 * 每个实例对应一条输出规则
 */
public interface IStreamDispatchComponent extends IBatchComponent {

    /**
     * 对数据根据业务规则做分发
     *
     * @param data
     * @param outputCollectorMap 可用的下游.
     */
    void fork(BatchData data, Map<String, OutputCollector> outputCollectorMap);
}