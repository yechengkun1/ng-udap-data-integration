package com.newland.bd.submitter.common.annotation;

import java.lang.annotation.*;

/**
 * Created by lcs on 2019/8/8.
 * 标记类作为提交器实现类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UdapSubmitter {
    /**
     * 提交器名称,必填
     *
     * @return 提交器名称
     */
    String code();

    /**
     * 提交器类型.  指定hadoop、kafka、redis、db...
     *
     * @return 依赖的包目录, 数组
     */
    String[] type() default {};
}
