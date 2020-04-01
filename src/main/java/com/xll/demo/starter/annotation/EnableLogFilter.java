package com.xll.demo.starter.annotation;

import com.xll.demo.starter.config.LogFilterAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @Author：xuliangliang
 * @Description：启动日志过滤器注解
 * @Date：11:10 下午 2020/4/1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogFilterAutoConfiguration.class)
public @interface EnableLogFilter {

}
