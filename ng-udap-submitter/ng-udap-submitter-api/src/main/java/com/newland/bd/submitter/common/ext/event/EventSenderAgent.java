package com.newland.bd.submitter.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

import java.util.Queue;

/**
 * 事件传递代理.
 * <p>
 * User: YECK
 */
public class EventSenderAgent implements IEventSender {
    private static EventSenderAgent eventSender;

    private Queue<ISubmitterEvent> transferQueue;

    private EventSenderAgent(Queue<ISubmitterEvent> toSendEventQueue) {
        this.transferQueue = toSendEventQueue;
    }

    public static IEventSender getInstance() {
        return eventSender;
    }

    /**
     * @param transferQueue
     */
    public synchronized static void init(Queue<ISubmitterEvent> transferQueue) {
        if (eventSender == null) {
            eventSender = new EventSenderAgent(transferQueue);
        }
    }

    /**
     * 发送事件往queue中, 供消费者线程使用
     *
     * @param event
     */
    public void sendEvent(ISubmitterEvent event) {
        if (this.transferQueue != null) {
            this.transferQueue.offer(event);
        }
    }

    @Override
    public void sendEvent(ComputerCenterTags tags, AbstractMessageContent content) {
        SubmitterEvent event = new SubmitterEvent(tags, content);
        this.sendEvent(event);
    }
}