package com.newland.bd.component.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lcs on 2019/8/8.
 * 标记类作为组件实现类
 *
 * @author lcs
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UdapComponent {
    /**
     * 组件名称,必填
     *
     * @return 组件名称
     */
    String code();

    /**
     * 组件类型.  指定hadoop、kafka、redis、db...
     * @return 依赖的包目录,数组
     */
    String[] type() default {};
}
