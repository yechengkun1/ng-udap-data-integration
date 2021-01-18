package com.newland.bd.component.common.ext.metrics.impl;

import com.newland.bd.component.common.ext.metrics.ISinkComponentMetricsCollector;
import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * sink组件指标
 * User: YECK
 * Date: 2019/9/26
 */
public class SinkBusinessMetriceCollecter implements ISinkComponentMetricsCollector {

    private AtomicLong recordOut;  //输入字节数
    private AtomicLong bytesOut; //输入记录数
    private AtomicLong filesOut; //输入文件数

    public SinkBusinessMetriceCollecter() {

        recordOut = new AtomicLong(0);
    }

    public void addOutRecords(long n) {

        recordOut.addAndGet(n);
    }

    public void addOutBytes(long n) {
        if (bytesOut == null) {
            bytesOut = new AtomicLong(0);
        }
        bytesOut.addAndGet(n);
    }

    @Override
    public void addOutFiles(int n) {
        if (filesOut == null) {
            filesOut = new AtomicLong(0);
        }
        filesOut.addAndGet(n);
    }

    @Override
    public long getOutRecords() {
        if (recordOut == null) {
            recordOut = new AtomicLong(0);
        }
        return recordOut.get();
    }

    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_OUT, recordOut.get() + "");
        if (bytesOut != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_BYTENUM_OUT, (bytesOut.get()) + "");
        }
        if (filesOut != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_OUT, (filesOut.get()) + "");
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
        final StringBuilder sb = new StringBuilder("SinkBusinessMetriceCollecter{");
        sb.append("recordOut=").append(recordOut);
        sb.append(", bytesOut=").append(bytesOut);
        sb.append(", filesOut=").append(filesOut);
        sb.append('}');
        return sb.toString();
    }
}