package com.newland.bd.submitter.common.ext.metrics.control.impl;

import com.newland.bd.ngudap.typeenum.BusinessMetricEnum;
import com.newland.bd.submitter.common.ext.metrics.control.IClearSubmitterMetricsCollector;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 清理类的指标.
 * User: YECK
 */
public class ClearSubmitterMetriceCollecter implements IClearSubmitterMetricsCollector {

    private static final long INIT_VALUE = -1;

    private AtomicLong recordDelete; //删除记录数
    private AtomicLong bytesDelete; //删除字节数
    private AtomicLong filesDelete; //删除文件数

    public ClearSubmitterMetriceCollecter() {
        recordDelete = new AtomicLong(INIT_VALUE);
        bytesDelete = new AtomicLong(INIT_VALUE);
        filesDelete = new AtomicLong(INIT_VALUE);
    }

    @Override
    public void addDeleteRecords(long n) {

    }

    @Override
    public void addDeleteBytes(long n) {

    }

    @Override
    public void addDeleteFiles(int n) {

    }

    @Override
    public Map<BusinessMetricEnum, String> getMetricsMap() {
        Map<BusinessMetricEnum, String> metricsMap = new HashMap<>();
        //暂时不输出清理类指标
//        if (filesDelete.get() > INIT_VALUE) {
//            metricsMap.put(BusinessMetricEnum.CPT_BIS_BYTENUM_OUT, (filesDelete.get() - INIT_VALUE) + "");
//        }
//        if (recordDelete.get() > INIT_VALUE) {
//            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_IN, (recordDelete.get() - INIT_VALUE) + "");
//        }
//        if (bytesDelete.get() > INIT_VALUE) {
//            metricsMap.put(BusinessMetricEnum.CPT_BIS_FILENUM_OUT, (bytesDelete.get() - INIT_VALUE) + "");
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
}