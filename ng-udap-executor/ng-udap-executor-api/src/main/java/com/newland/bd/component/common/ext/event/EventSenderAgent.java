package com.newland.bd.component.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

import java.util.Queue;

/**
 * 事件传递代理.
 * <p>
 * User: YECK
 * Date: 2019/9/25
 */
public class EventSenderAgent implements IEventSender {
    private static EventSenderAgent eventSender;

    private Queue<IComponentEvent> transferQueue;

    private EventSenderAgent(Queue<IComponentEvent> toSendEventQueue) {
        this.transferQueue = toSendEventQueue;
    }

    public static IEventSender getInstance() {
        return eventSender;
    }

    /**
     * @param transferQueue
     */
    public synchronized static void init(Queue<IComponentEvent> transferQueue) {
        if (eventSender == null) {
            eventSender = new EventSenderAgent(transferQueue);
        }
    }

    /**
     * 发送事件往queue中, 供消费者线程使用
     *
     * @param event
     */
    public void sendEvent(IComponentEvent event) {
        if (this.transferQueue != null) {
            this.transferQueue.offer(event);
        }
    }

    @Override
    public void sendEvent(ComputerCenterTags tags, AbstractMessageContent content) {
        ComponentEvent event = new ComponentEvent(tags, content);
        this.sendEvent(event);
    }
}