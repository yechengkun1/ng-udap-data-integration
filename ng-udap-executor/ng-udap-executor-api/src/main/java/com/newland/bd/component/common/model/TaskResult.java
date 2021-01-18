package com.newland.bd.component.common.model;

/**
 * 存放控制力与组件运行结果.
 */
public class TaskResult {
    boolean isSuccess; //组件运行是否成功
    String resultDesc;  //运行结果描述信息

    public TaskResult(boolean isSuccess) {
        this(isSuccess, "");
    }

    public TaskResult(boolean isSuccess, String resultDesc) {
        this.isSuccess = isSuccess;
        this.resultDesc = resultDesc;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    @Override
    public String toString() {
        return "TaskResult{" + "isSuccess=" + isSuccess + ", resultDesc='" + resultDesc + '\'' + '}';
    }
}


