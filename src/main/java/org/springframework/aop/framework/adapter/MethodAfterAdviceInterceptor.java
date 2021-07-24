package org.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.MethodAfterAdvice;

/**
 * @author augenye
 * @date 2021/7/24
 * @description
 */
public class MethodAfterAdviceInterceptor implements MethodInterceptor {


    private MethodAfterAdvice advice;

    public MethodAfterAdviceInterceptor(MethodAfterAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object obj = methodInvocation.proceed();
        this.advice.after(obj);
        return obj;
    }
}
