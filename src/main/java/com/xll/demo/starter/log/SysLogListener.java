package com.xll.demo.starter.log;

import com.xll.demo.starter.entity.SysLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * @Author：xuliangliang
 * @Description：日志事件接听器
 * @Date：11:47 下午 2020/4/1
 */
@Slf4j
public class SysLogListener {

    @Async
    @Order
    @EventListener(SysLogDTO.class)
    public void sysLogListener(SysLogDTO sysLogDTO){
        log.info("日志事件接听器触发，接受到的数据为：[{}]", sysLogDTO.toString());
    }

}
