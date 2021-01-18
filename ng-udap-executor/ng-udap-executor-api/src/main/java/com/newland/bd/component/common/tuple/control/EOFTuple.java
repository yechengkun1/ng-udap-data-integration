package com.newland.bd.component.common.tuple.control;

import com.newland.bd.component.common.tuple.ControlTuple;

import java.util.HashMap;
import java.util.Map;

/**
 * 结束消息. 表明上游已经发送完所有的数据了.
 * User: YECK
 * Date: 2019/10/24
 */
public class EOFTuple implements ControlTuple {

    @Override
    public Map<String, String> getControlInfo() {
        return new HashMap<>();
    }
}