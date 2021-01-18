package com.newland.bd.component.common.tuple;

import com.newland.bd.component.common.model.Tuple;

import java.util.Map;

/**
 * 控制消息, 用于在数据流组件之间传递附加信息，如文件名，文件打开关闭事件等
 * 控制指令由不同Reader发起，不同的writer处理. 不能处理的进行忽略.
 * 采用Map<String,String>存放信息内容，以避免不同组件classloader的问题. 组件交互间的信息key和格式由组件自行协定.
 * User: YECK
 * Date: 2019/10/24
 */
public interface ControlTuple extends Tuple {


    /**
     * 获取控制消息内容
     *
     * @return 控制消息内容Map.
     */
    public Map<String, String> getControlInfo();

}