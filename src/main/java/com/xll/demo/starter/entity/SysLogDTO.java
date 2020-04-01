package com.xll.demo.starter.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysLogDTO {
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 执行时间
     */
    private Long timeLong;
    /**
     * 操作IP地址
     */
    private String remoteAddr;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 异常信息
     */
    private String msg;
}
