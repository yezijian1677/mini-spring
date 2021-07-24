package org.springframework.aop.framework;


/**
 * @author derekyi
 * @date 2020/12/6
 */
public interface MethodAfterAdvice extends AfterAdvice {

	void after( Object target) throws Throwable;
}
