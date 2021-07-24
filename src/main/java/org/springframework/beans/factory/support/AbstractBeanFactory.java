package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 集成单例注册和获取bean的bean工厂
 * @author derekyi
 * @date 2020/11/22
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	@Override
	public Object getBean(String name) throws BeansException {
		// 1. 获取单例bean，如果存在则之间返回
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}
		// 2. bean工厂中中获取不到bean对象，则根据bean定义，创建bean
		BeanDefinition beanDefinition = getBeanDefinition(name);
		// 3. 创建bean，由子类自行实现
		return createBean(name, beanDefinition);
	}

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
