package com.newland.bd.component.common.ext.state;

import com.newland.bd.component.common.tuple.batch.BatchData;

import java.util.List;

/**
 * 一个状态信息的存储接口
 * <p>
 * 1、存储每批数据的状态
 * 2、存储ssink组件的状态
 */
public interface IStatefulStorage {

    /**
     * 保存这一批的状态数据
     *
     * @param batchData
     * @throws Exception
     */
    void saveBatchData(BatchData batchData) throws Exception;

    /**
     * 某个组件完成一个batchData的数据存储时调用
     *
     * @param batchData
     * @param componentInstanceId
     * @throws Exception
     */
    void completeBatchData(BatchData batchData, String componentInstanceId) throws Exception;

    /**
     * 获取之前未完成的批数据列表
     *
     * @return 返回需要保存的数据
     * @throws Exception
     */
    List<BatchData> inflightBatchDatas() throws Exception;

    /**
     * 报错当前sink组件的状态信息
     *
     * @param stateInfo
     */
    void saveSinkStateInfo(String stateInfo);

    /**
     * 获取sink组件最后存档的位置
     *
     * @return
     */
    String getSinkStateInfo();
}
