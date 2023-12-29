package com.akck.aop;


import com.akck.mapper.OperateLogMapper;
import com.akck.pojo.OperateLog;
import com.akck.utils.JwtUtils;
import com.akck.utils.ThreadLocalUtil;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component// 交给ioc容器
@Aspect // 指定当前类为切面类
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(com.akck.anno.Log)")// 自定义注解
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人的ID - 当前登录员工的id
        // 从线程中获得jwt令牌
        String jwt = ThreadLocalUtil.get();
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作的方法名
        String methodName = joinPoint.getSignature().getName();
        // 操作方法传入的参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 调用原始目标方法运行
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        // 方法执行的返回值
        String returnValue = JSONObject.toJSONString(result);
        // 方法的执行耗时
        Long costTime = end - begin;
        // 记录操作日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志：{}", operateLog);
        return result;
    }
}
