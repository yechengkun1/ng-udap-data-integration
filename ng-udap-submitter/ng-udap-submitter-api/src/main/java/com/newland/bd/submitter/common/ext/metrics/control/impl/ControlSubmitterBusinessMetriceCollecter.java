package com.newland.bd.submitter.common.ext.metrics.control.impl;

import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;
import com.newland.bd.submitter.common.ext.metrics.audit.IMetricsAuditAble;
import com.newland.bd.submitter.common.ext.metrics.control.IControlSubmitterMetricsCollector;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 控制流导入导出类提交器提交器业务指标收集
 * User: YECK
 */
public class ControlSubmitterBusinessMetriceCollecter implements IControlSubmitterMetricsCollector, IMetricsAuditAble {

    private AtomicLong recordIn;  //输入字节数
    private AtomicLong recordFilter; //过滤记录数
    private AtomicLong recordError; //过滤记录数
    private AtomicLong recordOut; //输出记录数
    private AtomicLong bytesIn; //输入记录数
    private AtomicLong bytesOut; //输出记录数
    private AtomicLong filesIn; //输入文件数
    private AtomicLong filesOut; //输出文件数

    public ControlSubmitterBusinessMetriceCollecter() {

    }

    public void addInRecords(long n) {
        if (recordIn == null) {
            recordIn = new AtomicLong();
        }
        recordIn.addAndGet(n);
    }

    public void addInBytes(long n) {
        if (bytesIn == null) {
            bytesIn = new AtomicLong();
        }
        bytesIn.addAndGet(n);
    }

    @Override
    public void addInFiles(int n) {
        if (filesIn == null) {
            filesIn = new AtomicLong();
        }
        filesIn.addAndGet(n);
    }

    public void addOutRecords(long n) {
        if (recordOut == null) {
            recordOut = new AtomicLong();
        }
        recordOut.addAndGet(n);
    }

    @Override
    public void addFilterRecords(long n) {
        if (recordFilter == null) {
            recordFilter = new AtomicLong();
        }
        recordFilter.addAndGet(n);
    }

    @Override
    public void addErrorRecords(long n) {
        if (recordError == null) {
            recordError = new AtomicLong();
        }
        recordError.addAndGet(n);
    }

    public void addOutBytes(long n) {
        if (bytesOut == null) {
            bytesOut = new AtomicLong();
        }
        bytesOut.addAndGet(n);
    }

    @Override
    public void addOutFiles(int n) {
        if (filesOut == null) {
            filesOut = new AtomicLong();
        }
        filesOut.addAndGet(n);
    }

    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        if (recordIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_IN, (recordIn.get()) + "");
        }
        if (recordOut != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_RECORD_OUT, (recordOut.get()) + "");
        }
        if (bytesIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_BYTENUM_IN, (bytesIn.get()) + "");
        }
        if (bytesOut != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_BYTENUM_OUT, (bytesOut.get()) + "");
        }
        if (filesIn != null) {
            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_IN, (filesIn.get()) + "");
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
    public long getFilterRecords() {
        return recordFilter == null ? -1 : recordFilter.get();
    }

    @Override
    public long getErrorRecords() {
        return recordError == null ? -1 : this.recordError.get();
    }

    @Override
    public long getInputRecords() {
        return recordIn == null ? -1 : recordIn.get();
    }

    @Override
    public long getOutputRecords() {
        return recordOut == null ? -1 : this.recordOut.get();
    }
}