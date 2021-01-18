package com.newland.bd.submitter.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

/**
 * 发送事件对象
 */
public interface IEventSender {

    /**
     * 发送一个事件.
     *
     * @param event 事件
     */
    void sendEvent(ISubmitterEvent event);

    /**
     * 发送一个事件.
     *
     * @param tags
     * @param content
     */
    void sendEvent(ComputerCenterTags tags, AbstractMessageContent content);
}
