package com.newland.bd.component.common.tuple.batch;

import java.util.Map;

/**
 * 一个BatchData它所属的插件的业务属性
 * 如所属的kafka的offset，ftp文件信息，hdfs文件块信息
 * User: YECK
 * Date: 2021/1/18
 */
public interface BatchDataAttributes {

    Map<String, String> getAttributes();

    void setAttributes(String key, String value);

    String getAttribute(String key);
}