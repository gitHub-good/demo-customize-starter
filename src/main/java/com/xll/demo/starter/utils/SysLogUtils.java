package com.xll.demo.starter.utils;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.xll.demo.starter.annotation.SysLog;
import com.xll.demo.starter.entity.SysLogDTO;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @Author：xuliangliang
 * @Description：日志工具类
 * @Date：11:36 下午 2020/4/1
 */
@UtilityClass
public class SysLogUtils {
    public SysLogDTO getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        SysLogDTO sysLog = new SysLogDTO();
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setUserAgent(request.getHeader("user-agent"));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        sysLog.setStartTime(LocalDateTime.now());
        return sysLog;
    }
}
