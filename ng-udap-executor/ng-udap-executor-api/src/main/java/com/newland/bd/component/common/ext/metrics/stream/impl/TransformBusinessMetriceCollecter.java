package com.newland.bd.component.common.ext.metrics.stream.impl;

import com.newland.bd.component.common.ext.metrics.stream.ITransformComponentMetricsCollector;
import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Transfor组件指标
 * User: YECK
 * Date: 2019/9/26
 */
public class TransformBusinessMetriceCollecter implements ITransformComponentMetricsCollector {

    private AtomicLong recordOut;  //转换组件输出记录数
    private AtomicLong recordFilter; //转换组件过滤记录数
    private AtomicLong recordError; //转换组件错误记录数

    public TransformBusinessMetriceCollecter() {
        recordOut = new AtomicLong(0);
    }

    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_OUT, recordOut.get() + "");
//        if (recordFilter.get() != INIT_VALUE) {
//            metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_FILTER, (recordFilter.get() - INIT_VALUE) + "");
//        }
//        if (recordError.get() != INIT_VALUE) {
//            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_ERROR, (recordError.get() - INIT_VALUE) + "");
//        }
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

    @Override
    public void addOutRecords(long n) {
        recordOut.addAndGet(n);
    }

    @Override
    public void addFilterRecords(long n) {
        if (recordFilter == null) {
            recordFilter = new AtomicLong(0);
        }
        recordFilter.addAndGet(n);
    }

    @Override
    public void addErrorRecords(long n) {
        if (recordError == null) {
            recordError = new AtomicLong(0);
        }
        recordError.addAndGet(n);
    }

    public long getOutRecords() {
        return recordOut.get();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransformBusinessMetriceCollecter{");
        sb.append("recordOut=").append(recordOut);
        sb.append(", recordFilter=").append(recordFilter);
        sb.append(", recordError=").append(recordError);
        sb.append('}');
        return sb.toString();
    }
}