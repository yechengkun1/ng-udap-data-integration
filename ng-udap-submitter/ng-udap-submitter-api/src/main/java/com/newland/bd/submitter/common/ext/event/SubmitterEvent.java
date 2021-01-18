package com.newland.bd.submitter.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

/**
 * Created with IntelliJ IDEA.
 * User: YECK
 */
public class SubmitterEvent implements ISubmitterEvent {
    private ComputerCenterTags tags;
    private AbstractMessageContent content;

    public SubmitterEvent(ComputerCenterTags tags, AbstractMessageContent content) {
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