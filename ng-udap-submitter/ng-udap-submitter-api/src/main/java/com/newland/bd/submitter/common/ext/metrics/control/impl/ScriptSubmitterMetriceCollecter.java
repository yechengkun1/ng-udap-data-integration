package com.newland.bd.submitter.common.ext.metrics.control.impl;

import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;
import com.newland.bd.submitter.common.ext.metrics.control.IScriptSubmitterMetricsCollector;

import java.util.HashMap;
import java.util.Map;

/**
 * 脚本类业务指标收集
 * User: YECK
 */
public class ScriptSubmitterMetriceCollecter implements IScriptSubmitterMetricsCollector {

    @Override
    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        //暂时不输出脚本类指标

        return metricsMap;
    }

    @Override
    public Map<String, String> getStringMetricsMap() {
        Map<BusinessMetricEnum, String> map = getMetricsMap();
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<BusinessMetricEnum, String> entry : map.entrySet()) {
            result.put(entry.getKey().name(), entry.getValue());
        }
        return result;
    }
}