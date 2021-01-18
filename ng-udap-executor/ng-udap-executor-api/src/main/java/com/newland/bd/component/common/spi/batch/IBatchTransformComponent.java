package com.newland.bd.component.common.spi.batch;

import com.newland.bd.component.common.ext.collector.OutputCollector;
import com.newland.bd.component.common.spi.IBatchComponent;
import com.newland.bd.component.common.tuple.batch.BatchData;

/**
 * 数据清洗转换接口
 */
public interface IBatchTransformComponent extends IBatchComponent {

    /**
     * 对数据做清洗转换处理
     *
     * @param receive 接收上游给的数据
     * @return 返回结果. null表示该数据被过滤
     */
    void filterAndTransform(BatchData receive, OutputCollector collector);
}
