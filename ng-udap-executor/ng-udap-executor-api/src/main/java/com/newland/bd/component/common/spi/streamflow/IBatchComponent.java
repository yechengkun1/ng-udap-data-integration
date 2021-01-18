package com.newland.bd.component.common.spi.streamflow;

import com.newland.bd.component.common.spi.IBaseComponent;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: YECK
 * \
 */
public interface IBatchComponent extends IBaseComponent {

    /**
     * 只有当任务执行成功后调用,用来做数据的check,提交,清理动作的.
     * 资源连接销毁，请使用destroy()
     */
    void complete();
}
