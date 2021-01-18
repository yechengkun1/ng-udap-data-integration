package com.newland.bd.component.common.ext.state;

/**
 * 一个状态信息的存储接口
 * <p>
 * 1、存储每批数据的状态
 * 2、存储ssink组件的状态
 */
public interface IState {

    /**
     * 保存组件的状态信息.
     *
     * @param stateInfo 组件的存档信息
     * @throws Exception
     */
    void saveStateInfo(String stateInfo) throws Exception;
}
