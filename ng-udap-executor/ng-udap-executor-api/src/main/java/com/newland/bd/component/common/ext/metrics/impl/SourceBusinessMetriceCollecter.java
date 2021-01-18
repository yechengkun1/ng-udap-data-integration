package com.newland.bd.component.common.ext.metrics.impl;

import com.newland.bd.component.common.ext.metrics.ISourceComponentMetricsCollector;
import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * source组件指标
 * User: YECK
 * Date: 2019/9/26
 */
public class SourceBusinessMetriceCollecter implements ISourceComponentMetricsCollector {

    private AtomicLong recordIn;  //输入字节数
    private AtomicLong bytesIn; //输入记录数
    private AtomicLong filesIn; //输入文件数

    public SourceBusinessMetriceCollecter() {
        recordIn = new AtomicLong(0);
    }

    public void addInRecords(long n) {
        recordIn.addAndGet(n);
    }

    public void addInBytes(long n) {
        if (bytesIn == null) {
            bytesIn = new AtomicLong(0);
        }
        bytesIn.addAndGet(n);
    }

    @Override
    public void addInFiles(int n) {
        if (filesIn == null) {
            filesIn = new AtomicLong(0);
        }
        filesIn.addAndGet(n);
    }

    @Override
    public long getInRecords() {
        return recordIn.get();
    }

    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        if (recordIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_IN, recordIn.get() + "");
        }
        if (bytesIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_BYTENUM_IN, (bytesIn.get()) + "");
        }
        if (filesIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_IN, (filesIn.get()) + "");
        }
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("SourceBusinessMetriceCollecter{");
        sb.append("recordIn=").append(recordIn);
        sb.append(", bytesIn=").append(bytesIn);
        sb.append(", filesIn=").append(filesIn);
        sb.append('}');
        return sb.toString();
    }
}