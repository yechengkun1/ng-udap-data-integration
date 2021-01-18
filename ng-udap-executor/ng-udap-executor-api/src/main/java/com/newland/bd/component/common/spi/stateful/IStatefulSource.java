package com.newland.bd.component.common.spi.stateful;

import com.newland.bd.component.common.ext.state.IComponentStatefuleStorage;
import com.newland.bd.component.common.tuple.batch.BatchData;

/**
 * 有状态的源组件。
 * 当发生断点续作时，可以重现之前未完成的batchData
 * User: YECK
 *
 */
public interface IStatefulSource {
    /**
     * 重现某一批数据
     *
     * @return
     */
    void reappearBatchData(BatchData batchData);

    /**
     * 组件状态的存储接口，当组件submit某一批BatchData，即可通过statefulStorage存储状态
     *
     * @return 组件当前位置信息. 如合并文件的位置
     */
    void setStateInfo(IComponentStatefuleStorage statefulStorage);
}