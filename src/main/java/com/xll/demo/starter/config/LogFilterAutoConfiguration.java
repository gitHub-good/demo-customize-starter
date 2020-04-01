package com.xll.demo.starter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author：xuliangliang
 * @Description：自动装配 LogFilterRegistrationBean
 * @Date：11:06 下午 2020/4/1
 */
@Configuration
@ConditionalOnClass({LogFilterRegistrationBean.class, LogFilter.class})
public class LogFilterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LogFilterRegistrationBean.class)
    public LogFilterRegistrationBean logFilterRegistrationBean(){
        return new LogFilterRegistrationBean();
    }
}
