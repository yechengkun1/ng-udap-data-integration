package com.newland.bd.component.common.spi;

/**
 * \* 流组件
 * \* User: YECK
 * \
 */
public interface IStreamComponent extends IBaseComponent {

    /**
     * 平台定时每30S调用一次. 可以在组件内部做一些提交动作
     */
    void timmer();
}
