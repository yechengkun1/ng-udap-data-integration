package com.newland.bd.component.common.ext.event;

import com.newland.bd.ngudap.model.msg.content.AbstractMessageContent;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;

import java.io.Serializable;

/**
 * 组件输出事件
 * User: YECK
 * Date: 2019/9/25
 */
public interface IComponentEvent extends Serializable {
    public ComputerCenterTags getTag();
    public AbstractMessageContent getContent();
}