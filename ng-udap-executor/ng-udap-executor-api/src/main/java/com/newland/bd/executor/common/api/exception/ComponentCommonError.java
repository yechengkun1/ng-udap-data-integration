package com.newland.bd.executor.common.api.exception;

import com.newland.bd.ngudap.exception.base.ErrorCode;

/**
 * Created by lcs on 2019/8/2.
 *
 * @author lcs
 */

public enum ComponentCommonError implements ErrorCode {
    C_COMMON_00001("C-COMMON-00001", "出现运行时异常", "运行时异常[%s]"),
    C_COMMON_00002("C-COMMON-00002", "缺少组件参数", "缺少组件参数[%s]"),
    C_COMMON_00003("C-COMMON-00003", "非法的参数值", "非法的参数值[%s]"),
    C_COMMON_00004("C-COMMON-00004", "IO处理异常", "IO处理异常[%s]"),
    C_COMMON_00005("C-COMMON-00005", "MapReduce没有加载到hdfs上的lib包", "MapReduce没有加载到hdfs上的lib包.路径[%s],扫描到hdfs上的lib包[%s]"),
    C_COMMON_00006("C-COMMON-00006", "获取数据库连接配置失败", "获取数据库连接配置失败,数据库连接名为[%s]，失败原因是[%s]"),
    C_COMMON_00007("C-COMMON-00007", "输入字段个数异常","当前任务源数据中的实际字段数：[%s],源实体字段数:[%s],源数据[%s],列分隔符[%s]");


    public static final long serialVersionUID = 1;
    private final String code;
    private final String desc;
    private final String msg;

    private ComponentCommonError(String code, String desc, String msg) {
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    @Override
    public String toString() {
        return String.format("Code:[%s], Describe:[%s]", this.code, this.desc);
    }
}
