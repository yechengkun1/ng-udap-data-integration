package com.newland.bd.component.common.spi.batch;

import com.newland.bd.component.common.ext.collector.OutputCollector;
import com.newland.bd.component.common.spi.IBatchComponent;
import com.newland.bd.component.common.spi.SourceSplit;

import java.util.List;

/**
 * 批处理的源，运行完成后会退出.
 */
public interface IBatchSourceComponent extends IBatchComponent {

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
     * 当分片小于并行度时，框架会发生告警，部分并行的进程空跑并很快退出.
     * 当分片大于并行度时，框架会发生告警，超出的分片在BE内部排队执行.
     * @throws Exception
     */
    public List<SourceSplit> getSplits(int parallelism) throws Exception;

    /**
     * 处理一个分片的数据. 如果这个函数执行完毕，框架会调用下一个split，所有属于本并行子任务的分片数据全部处理完成，框架会退出
     *
     * @param split
     * @param collector
     * @return
     */
    public void run(SourceSplit split, OutputCollector collector);
}
