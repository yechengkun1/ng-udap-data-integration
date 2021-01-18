package com.newland.bd.submitter.common.ext.metrics;

import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;

import java.util.Map;

/**
 * \* 提交器实例度量信息.是一个蒙面模式的接口, 包含
 * \* User: YECK
 * \
 */
public interface ISubmitterBusinessMetricsCollector {

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
