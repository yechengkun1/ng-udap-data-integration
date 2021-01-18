package com.newland.bd.submitter.common.model;

import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;
import com.newland.bd.submitter.common.constant.SubmitterConfigKey;
import org.apache.commons.configuration2.Configuration;

import java.io.Serializable;

/**
 * 提交器实例信息
 * User: YECK
 */
public class SubmitterInstanceInfo implements Serializable {

    /*整个JOBID*/
    protected String tenantId;
    /*整个JOBID*/
    protected String jobId;
    /*所属taskID*/
    protected String taskId;
    /*所属task名*/
    protected String taskName;
    /* 提交器编码*/
    protected String componentCode;

    /*实例ID.*/
    protected ComputerCenterTags tags;

    /*实例ID.*/
    protected String instanceId;

    protected Configuration taskConf;

    private SubmitterInstanceInfo() {
    }

    public Configuration getTaskConf() {
        return taskConf;
    }

    public SubmitterInstanceInfo(Configuration taskConf) {
        this.tenantId = taskConf.getString(SubmitterConfigKey.KEY_TENANTID);
        this.jobId = taskConf.getString(SubmitterConfigKey.KEY_JOB_ID);
        this.taskId = taskConf.getString(SubmitterConfigKey.KEY_TASK_ID);
        this.taskName = taskConf.getString(SubmitterConfigKey.KEY_TASK_NAME);
        this.componentCode = taskConf.getString(SubmitterConfigKey.KEY_COMPONENT_CODE);
        this.instanceId = taskConf.getString(SubmitterConfigKey.KEY_INSTANCE_ID);
        tags = new ComputerCenterTags(tenantId, jobId, taskId, instanceId, "STAGE_RUNNING");
        this.taskConf = taskConf;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSubmitterCode() {
        return componentCode;
    }

    public void setSubmitterCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public ComputerCenterTags getTags() {
        return tags;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    public String toString() {
        return "SubmitterInstanceInfo{" + "tenantId='" + tenantId + '\'' + ", jobId='" + jobId + '\'' + ", taskId='" + taskId + '\'' + ", taskName='" + taskName + '\'' + ", componentCode='" + componentCode + '\'' + ", tags=" + tags + ", instanceId='" + instanceId + '\'' + '}';
    }
}