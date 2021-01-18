package com.newland.bd.component.common.ext.state;

/**
 * 一个状态信息的存储接口
 * <p>
 * * 1、存储组件的状态
 */
public interface IComponentStatefuleStorage {

    /**
     * 保存组件的状态信息.
     *
     * @param stateInfo 组件的存档信息
     * @throws Exception
     */
    void saveStateInfo(String stateInfo) throws Exception;

    /**
     * 保存组件的状态信息.
     *
     * @return 返回最后一次组件的存档信息
     * @throws Exception
     */
    String getLastStateInfo() throws Exception;
}
