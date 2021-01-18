package com.newland.bd.component.common.spi.streamflow.stateful;

import com.newland.bd.component.common.tuple.batch.BatchData;

/**
 * 有状态的源组件。
 * 当发生断点续作时，可以重现之前未完成的batchData
 * User: YECK
 * Date: 2021/1/18
 */
public interface IStatefulSource {
    /**
     * 重现某一批数据
     *
     * @return
     */
    void reappearBatchData(BatchData batchData);
}