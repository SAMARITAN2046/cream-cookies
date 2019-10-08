package com.lyq.edu.design.lock;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Samaritan
 * @date 2019/10/8
 */
public interface DistributeLock {
    /**
     * 获得锁
     * @param key
     * @param lease
     * @param timeUnit
     * @return
     */
    Boolean tryLock(final String key,final Long lease, final TimeUnit timeUnit);

    /**
     * 释放锁
     * @param key
     * @param lease
     * @param timeUnit
     * @return
     */
    Boolean unLock(final String key, final Long lease, final TimeUnit timeUnit);
}
