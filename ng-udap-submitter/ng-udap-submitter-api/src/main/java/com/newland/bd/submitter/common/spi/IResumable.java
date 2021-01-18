package com.newland.bd.submitter.common.spi;

/**
 * 表示提交器具备断点接管的能力.  比如提交在mr上的任务，如果执行器中途意外退出，则框架会重新调用run. 如果提交器没有实现这个接口，则任务会失败
 * 一个提交器要具备接管能力有两种：
 * 1。提交器内部有状态逻辑，可以实现状态接管，典型的如mr提交器，flink提交器等， 框架提供SubmitterRuntimeContext的ISubmitterStatefuleStorage存储提交器状态
 * 2。提交器的逻辑是允许重做的，比如loadhive，只要具备beforeClean清理hive的能力，触发接管就等于触发重做.
 * User: YECK
 * Date: 2021/1/18
 */
public interface IResumable {

}