package com.newland.bd.component.common.tuple.format;

import java.util.List;

/**
 * \* 定义tuple的格式信息
 * 格式信息包含字段的定义信息等
 * \* User: YECK
 * \* Date: 2019/9/11
 * \
 */
public interface ITupleFormat {
    /**
     * 获取字段列表
     *
     * @return
     */
    public List<FieldInfo> getFields();

    /**
     * 根据字段名获取字段所在的下标
     * 下表从0开始
     *
     * @param fieldCode
     * @return
     */
    public int getFieldIndexByCode(String fieldCode);

    /**
     * 获取字段分隔符.
     *
     * @return
     */
    public String getFieldDelimiter();

    /**
     * 比较两个格式是否一致
     *
     * @param o
     * @return
     */
    public boolean equals(Object o);
}
