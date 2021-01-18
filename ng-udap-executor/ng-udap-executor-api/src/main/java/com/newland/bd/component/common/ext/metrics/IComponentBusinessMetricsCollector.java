package com.newland.bd.component.common.ext.metrics;

import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;

import java.util.Map;

/**
 * \* 组件实例度量信息.
 * \* User: YECK
 * \* Date: 2019/11/27
 * \
 */
public interface IComponentBusinessMetricsCollector {

    /**
     * 获取指标度量信息
     *
     * @return
     */
    public Map<BusinessMetricEnum, String> getMetricsMap();

    /**
     * 获取指标度量信息
     *
     * @return
     */
    public Map<String, String> getStringMetricsMap();
}
