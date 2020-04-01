package com.xll.demo.starter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 *
 * @Author：xuliangliang
 * @Description：封装LogFilter过滤器为Spring bean
 * @Date：11:00 下午 2020/4/1
 */
public class LogFilterRegistrationBean extends FilterRegistrationBean<LogFilter>{

    public LogFilterRegistrationBean(){
        super();
        //添加LogFilter过滤器
        this.setFilter(new LogFilter());
        //匹配所有路径
        this.addUrlPatterns("/*");
        //设置优先级
        this.setOrder(1);
        //设置过滤器名称
        this.setName("LogFilter");
    }

}
