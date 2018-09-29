/**
* Copyright: Copyright (c) 2018
* Company: www.91wutong.com
*/

package org.infrastructure.common.jstrategy;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.infrastructure.common.jstrategy.extension.spring.JspringStrategyProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 
 * @date 2018年9月29日
 * 
 * @author zhihong.he
 * @version 1.0
 * @since 7.1.1-SNAPSHOT
 */
public class DemoApplicationContext implements ApplicationContext {

    /* (non-Javadoc)
     * @see org.springframework.core.env.EnvironmentCapable#getEnvironment()
     */
    @Override
    public Environment getEnvironment() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#containsBeanDefinition(java.lang.String)
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanDefinitionCount()
     */
    @Override
    public int getBeanDefinitionCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanDefinitionNames()
     */
    @Override
    public String[] getBeanDefinitionNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanNamesForType(org.springframework.core.ResolvableType)
     */
    @Override
    public String[] getBeanNamesForType(ResolvableType type) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanNamesForType(java.lang.Class)
     */
    @Override
    public String[] getBeanNamesForType(Class<?> type) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanNamesForType(java.lang.Class, boolean, boolean)
     */
    @Override
    public String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeansOfType(java.lang.Class)
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeansOfType(java.lang.Class, boolean, boolean)
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit)
            throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanNamesForAnnotation(java.lang.Class)
     */
    @Override
    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeansWithAnnotation(java.lang.Class)
     */
    @Override
    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType)
            throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.ListableBeanFactory#findAnnotationOnBean(java.lang.String, java.lang.Class)
     */
    @Override
    public <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType)
            throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.String)
     */
    @Override
    public Object getBean(String name) throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.String, java.lang.Class)
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) new DemoBOProcessorImpl();
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.String, java.lang.Object[])
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.Class)
     */
    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getBean(java.lang.Class, java.lang.Object[])
     */
    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#containsBean(java.lang.String)
     */
    @Override
    public boolean containsBean(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#isSingleton(java.lang.String)
     */
    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#isPrototype(java.lang.String)
     */
    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#isTypeMatch(java.lang.String, org.springframework.core.ResolvableType)
     */
    @Override
    public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#isTypeMatch(java.lang.String, java.lang.Class)
     */
    @Override
    public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getType(java.lang.String)
     */
    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanFactory#getAliases(java.lang.String)
     */
    @Override
    public String[] getAliases(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.HierarchicalBeanFactory#getParentBeanFactory()
     */
    @Override
    public BeanFactory getParentBeanFactory() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.HierarchicalBeanFactory#containsLocalBean(java.lang.String)
     */
    @Override
    public boolean containsLocalBean(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.MessageSource#getMessage(java.lang.String, java.lang.Object[], java.lang.String, java.util.Locale)
     */
    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.MessageSource#getMessage(java.lang.String, java.lang.Object[], java.util.Locale)
     */
    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.MessageSource#getMessage(org.springframework.context.MessageSourceResolvable, java.util.Locale)
     */
    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationEventPublisher#publishEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void publishEvent(ApplicationEvent event) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationEventPublisher#publishEvent(java.lang.Object)
     */
    @Override
    public void publishEvent(Object event) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.core.io.support.ResourcePatternResolver#getResources(java.lang.String)
     */
    @Override
    public Resource[] getResources(String arg0) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.core.io.ResourceLoader#getClassLoader()
     */
    @Override
    public ClassLoader getClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.core.io.ResourceLoader#getResource(java.lang.String)
     */
    @Override
    public Resource getResource(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getId()
     */
    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getApplicationName()
     */
    @Override
    public String getApplicationName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getDisplayName()
     */
    @Override
    public String getDisplayName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getStartupDate()
     */
    @Override
    public long getStartupDate() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getParent()
     */
    @Override
    public ApplicationContext getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContext#getAutowireCapableBeanFactory()
     */
    @Override
    public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

}
