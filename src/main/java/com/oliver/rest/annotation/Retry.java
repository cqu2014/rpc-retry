package com.oliver.rest.annotation;

import com.oliver.rest.annotation.core.BaseRetryListener;
import com.oliver.rest.annotation.core.StopStrategyEnum;
import com.oliver.rest.annotation.core.WaitStrategyEnum;

import java.lang.annotation.*;

/**
 * 基于Guava-retry的重试注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retry {
    /**
     * 要求Callable返回非空
     *
     * @return
     */
    boolean requireNonNull() default false;

    /**
     * 重试的异常类数组
     *
     * @return
     */
    Class<? extends Exception>[] exceptionType() default {};

    /**
     * If has RuntimeException to attempt
     *
     * @return
     */
    boolean retryIfRuntimeException()  default false;

    /**
     * 等待策略
     *
     * @return
     */
    WaitStrategyEnum waitStrategy() default WaitStrategyEnum.FIXED_WAIT;

    /**
     * 重试停止策略
     *
     * @return
     */
    StopStrategyEnum stopStrategy() default StopStrategyEnum.STOP_AFTER_ATTEMPT_THREE;

    /**
     * 监听器列表
     *
     * @return
     */
    Class<? extends BaseRetryListener>[] retryListeners() default {};
}

