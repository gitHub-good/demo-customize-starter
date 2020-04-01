package com.xll.demo.starter.annotation;

import java.lang.annotation.*;

/**
 *
 * @Author：xuliangliang
 * @Description：操作日志注解
 * @Date：8:01 下午 2020/3/18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String msg();
}
