package com.newland.bd.component.common.spi.streamflow.stream;

import com.newland.bd.component.common.ext.collector.OutputCollector;
import com.newland.bd.component.common.spi.streamflow.IStreamComponent;
import com.newland.bd.component.common.spi.streamflow.SourceSplit;

import java.util.List;

//实时流处理的源，框架会持续调用取数据
public interface IStreamSourceSource extends IStreamComponent {

    /**
     * 判断这个组件是否支持分布式并行.
     *
     * @return false表示不支持分布式，只能单例并行
     */
    public boolean isSplitable();

    /**
     * 获取source的分片信息.  在分布式场景下，将源数据分片由不同的进程处理.
     *
     * @param parallelism 运维中设置的并行度.
     * @return 分片详细信息.
     * 当分片不等于并行度时，框架会抛出异常
     * @throws Exception
     */
    public List<SourceSplit> getSplits(int parallelism) throws Exception;

    /**
     * 处理一个分片的数据. 如果这个函数执行完毕，框架会调用下一个split，所有属于本并行子任务的分片数据全部处理完成，框架会退出
     *
     * @return tuples.大部分场景下，抽取数据都是一批一批抽取
     */
    void run(SourceSplit split, OutputCollector collector);
}
