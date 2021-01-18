package com.newland.bd.component.common.model;

import com.newland.bd.component.common.constant.ComponentConfigKey;
import com.newland.bd.ngudap.model.msg.tags.ComputerCenterTags;
import org.apache.commons.configuration2.Configuration;

import java.io.Serializable;

/**
 * 组件实例信息
 * User: YECK
 */
public class ComponentInstanceInfo implements Serializable {

    /*整个JOBID*/
    protected String tenantId;
    /*整个JOBID*/
    protected String jobId;
    /*所属taskID*/
    protected String taskId;
    /*所属task名*/
    protected String taskName;
    /* 组件编码*/
    protected String componentCode;
    /*并行度id*/
    protected int parallelismId;
    /*并行度总数*/
    protected int parallelismCnt;

    /*实例ID.*/
    protected ComputerCenterTags tags;

    /*实例ID.*/
    protected String instanceId;

    /**
     * task级参数
     */
    protected Configuration taskConf;

    /*数据流节点ID. 每个NODE由同一个componetCode的多个实例*/
    private String nodeId;
    /*本节点的组件实例并行度 */
    private int nodeParallelism;
    /*当前实例并行ID. 从0开始*/
    private int nodeParallelismId;

    private ComponentInstanceInfo() {
    }

    public Configuration getTaskConf() {
        return taskConf;
    }

    public ComponentInstanceInfo(Configuration taskConf) {
        this.tenantId = taskConf.getString(ComponentConfigKey.KEY_TENANTID);
        this.jobId = taskConf.getString(ComponentConfigKey.KEY_JOB_ID);
        this.taskId = taskConf.getString(ComponentConfigKey.KEY_TASK_ID);
        this.taskName = taskConf.getString(ComponentConfigKey.KEY_TASK_NAME);
        this.componentCode = taskConf.getString(ComponentConfigKey.KEY_COMPONENT_CODE);
        this.instanceId = taskConf.getString(ComponentConfigKey.KEY_INSTANCE_ID);
        this.parallelismId = taskConf.getInt(ComponentConfigKey.KEY_NODE_PARALLELISM_ID, 0);
        this.parallelismCnt = taskConf.getInt(ComponentConfigKey.KEY_NODE_PARALLELISM, 1);
        tags = new ComputerCenterTags(tenantId, jobId, taskId, instanceId, "STAGE_RUNNING");
        this.taskConf = taskConf;
        this.nodeId = taskConf.getString(ComponentConfigKey.KEY_NODE_ID);
        this.nodeParallelism = Integer.parseInt(taskConf.getString(ComponentConfigKey.KEY_NODE_PARALLELISM));
        this.nodeParallelismId = Integer.parseInt(taskConf.getString(ComponentConfigKey.KEY_NODE_PARALLELISM_ID));
    }

    public int getParallelismId() {
        return parallelismId;
    }

    public void setParallelismId(int parallelismId) {
        this.parallelismId = parallelismId;
    }

    public int getParallelismCnt() {
        return parallelismCnt;
    }

    public void setParallelismCnt(int parallelismCnt) {
        this.parallelismCnt = parallelismCnt;
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

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public ComputerCenterTags getTags() {
        return tags;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeParallelism() {
        return nodeParallelism;
    }

    public void setNodeParallelism(String nodeParallelism) {
        this.nodeParallelism = Integer.parseInt(nodeParallelism);
    }

    public void setNodeParallelism(int nodeParallelism) {
        this.nodeParallelism = nodeParallelism;
    }

    public int getNodeParallelismId() {
        return nodeParallelismId;
    }

    public void setNodeParallelismId(int nodeParallelismId) {
        this.nodeParallelismId = nodeParallelismId;
    }

    public void setNodeParallelismId(String nodeParallelismId) {
        this.nodeParallelismId = Integer.parseInt(nodeParallelismId);
    }

    public String getInstanceId() {
        return this.componentCode + "@" + this.nodeId + "@" + nodeParallelismId;
    }

    @Override
    public String toString() {
        return "InstanceContext{" + "nodeId='" + nodeId + '\'' + ", nodeParallelism='" + nodeParallelism + '\'' + ", nodeParallelismId='" + nodeParallelismId + '\'' + ", tags=" + tags + '}';
    }
}