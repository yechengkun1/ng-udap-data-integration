package com.newland.bd.component.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

/**
 * Created with IntelliJ IDEA.
 * User: YECK
 * Date: 2019/10/15
 */
public class ComponentEvent implements IComponentEvent {
    private ComputerCenterTags tags;
    private AbstractMessageContent content;

    public ComponentEvent(ComputerCenterTags tags, AbstractMessageContent content) {
        this.tags = tags;
        this.content = content;
    }

    @Override
    public ComputerCenterTags getTag() {
        return tags;
    }

    @Override
    public AbstractMessageContent getContent() {
        return content;
    }
}