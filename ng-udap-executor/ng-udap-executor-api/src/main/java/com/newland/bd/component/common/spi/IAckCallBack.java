package com.newland.bd.component.common.spi;

import com.newland.bd.component.common.tuple.batch.BatchData;

/**
 * 当框架确认所有下游插件都处理完这一批数据后，会回调这个函数.
 * User: YECK
 * Date: 2021/1/18
 */
public interface IAckCallBack {

    void callback(BatchData batchData);
}