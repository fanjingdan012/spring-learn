package com.fjd.mbt.config;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author I310818
 *
 */
@Component
public class BeanFactoryHolder implements BeanFactoryAware {
    private static BeanFactory beanFactory;
    private final static ReadWriteLock rwLock = new ReentrantReadWriteLock();

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.
     * springframework.beans.factory.BeanFactory)
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryHolder.beanFactory = beanFactory;
    }

    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public static <T> T getBean(Class<T> clazz) {
        Lock rlock = rwLock.readLock();
        rlock.lock();
        try {
            return beanFactory.getBean(clazz);
        } finally {
            rlock.unlock();
        }
    }
}