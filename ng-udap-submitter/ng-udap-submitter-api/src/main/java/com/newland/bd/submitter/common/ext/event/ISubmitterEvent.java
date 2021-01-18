package com.newland.bd.submitter.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

import java.io.Serializable;

/**
 * 提交器输出事件
 * User: YECK
 */
public interface ISubmitterEvent extends Serializable {
    public ComputerCenterTags getTag();

    public AbstractMessageContent getContent();
}