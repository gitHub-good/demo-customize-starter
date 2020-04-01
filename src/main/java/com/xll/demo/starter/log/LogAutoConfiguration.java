package com.xll.demo.starter.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @Author：xuliangliang
 * @Description：日志自动配置类
 * @Date：11:54 下午 2020/4/1
 */
@EnableAsync
@Slf4j
@Configuration
@ConditionalOnWebApplication
public class LogAutoConfiguration {

    @Bean
    public SysLogListener sysLogListener(){
        return new SysLogListener();
    }

    @Bean
    public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher) {
        return new SysLogAspect(publisher);
    }
}
