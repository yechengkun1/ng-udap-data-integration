package com.newland.bd.submitter.common.ext.state;

/**
 * 一个状态信息的存储接口
 * <p>
 * * 1、存储组件的状态
 */
public interface ISubmitterStatefuleStorage {

    /**
     * 保存提交器的状态信息.
     *
     * @param stateInfo 提交器的存档信息。 当提交器提交后，可以调用这个接口存储状态信息，如mr的jobid
     * @throws Exception
     */
    void saveStateInfo(String stateInfo) throws Exception;

    /**
     * 获取提交器的最后状态信息.
     *
     * @return 返回最后一次组件的存档信息
     * @throws Exception
     */
    String getLastStateInfo() throws Exception;
}
