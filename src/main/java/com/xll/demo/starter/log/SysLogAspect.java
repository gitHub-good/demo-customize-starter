package com.xll.demo.starter.log;

import com.xll.demo.starter.annotation.SysLog;
import com.xll.demo.starter.entity.SysLogDTO;
import com.xll.demo.starter.utils.SysLogUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;

/**
 *
 * @Author：xuliangliang
 * @Description：
 * @Date：11:26 下午 2020/4/1
 */
@Slf4j
@AllArgsConstructor
@Aspect
public class SysLogAspect {

    /**
     * 事件触发
     */
    private final ApplicationEventPublisher publisher;
    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint point, SysLog sysLog) throws Throwable {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLogDTO logVo = SysLogUtils.getSysLog();
        logVo.setMsg(sysLog.msg());
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Long endTime = System.currentTimeMillis();
        logVo.setTimeLong(endTime - startTime);
        publisher.publishEvent(logVo);
        Object obj = point.proceed();
        return obj;
    }
}
