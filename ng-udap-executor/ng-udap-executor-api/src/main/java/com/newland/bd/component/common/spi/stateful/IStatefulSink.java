package com.newland.bd.component.common.spi.stateful;

/**
 * 有状态的目标组件。
 * 当发生断点续作时，可以回滚到上一次BatchData提交时候的位置
 * User: YECK
 *
 */
public interface IStatefulSink {

    /**
     * 获取当前组件的状态信息. 当组件处理完成一个BatchData后，框架就会调用一次.
     * 并将返回的信息存储
     *
     * @return 组件的当前位置信息. 如合并文件的位置
     */
    String getStateInfo();

    /**
     * 回滚到stateInfo的位置
     *
     * @return
     */
    void rollback(String stateInfo);
}