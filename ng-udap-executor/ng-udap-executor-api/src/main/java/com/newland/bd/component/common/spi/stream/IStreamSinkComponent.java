package com.newland.bd.component.common.spi.stream;

import com.newland.bd.component.common.spi.IBatchComponent;
import com.newland.bd.component.common.tuple.batch.BatchData;

/**
 * 输出组件
 *
 * @author 叶承坤
 */
public interface IStreamSinkComponent extends IBatchComponent {

    /**
     * 写入数据.每来一条数据，就会触发一次writer
     *
     * @param receive
     */
    void writer(BatchData receive);
}
