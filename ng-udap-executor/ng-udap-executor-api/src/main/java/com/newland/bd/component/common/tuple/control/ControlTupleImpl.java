package com.newland.bd.component.common.tuple.control;

import com.newland.bd.component.common.tuple.ControlTuple;

import java.util.Map;

/**
 * 控制消息, 用于在数据流组件之间传递附加信息，如文件名，文件打开关闭事件等
 * User: YECK
 * Date: 2019/10/24
 */
public class ControlTupleImpl implements ControlTuple {
    private Map<String, String> info;

    public ControlTupleImpl() {
    }

    public ControlTupleImpl(Map<String, String> info) {
        this.info = info;
    }

    /**
     * 获取控制消息内容
     *
     * @return 控制消息内容Map. 采用Map<String,String>可以避免不同组件classloader的问题
     */
    public Map<String, String> getControlInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ControlTupleImpl{" + "info=" + info + '}';
    }
}