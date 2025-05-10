package org.freedom.verification.util;

import lombok.RequiredArgsConstructor;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RedisUtils {

    private final RedissonClient redissonClient;


    /**
     * 将值存储到Redis中
     *
     * @param key   键
     * @param value 值
     */
    public <T> void set (String key,T value) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    /**
     * 将值存储到Redis中
     *
     * @param key      键
     * @param value    值
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     */
    public <T> void set (String key,T value,long timeout,TimeUnit timeUnit) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        bucket.set(value,timeout,timeUnit);
    }

    /**
     * 根据键获取Redis中的值
     *
     * @param key 键
     * @return 值
     */
    public <T> T get (String key) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    /**
     * 递增操作
     *
     * @param key   键
     * @param delta 增加的值
     * @return 递增后的值，如果键不存在，则返回-1
     */
    public long increment(String key, long delta) {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
        return atomicLong.addAndGet(delta);
    }

    /**
     * 递减操作
     *
     * @param key   键
     * @param delta 减少的值
     * @return 递减后的值，如果键不存在，则返回-1
     */
    public long decrement(String key, long delta) {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
        return atomicLong.decrementAndGet();
    }

    /**
     * 递增操作
     *
     * @param key   键
     * @param delta 增加的值
     * @return 递增后的值，如果键不存在，则返回-1
     */
    public double increment(String key, double delta) {
        RAtomicDouble atomicDouble = redissonClient.getAtomicDouble(key);
        return atomicDouble.addAndGet(delta);
    }

    /**
     * 递减操作
     *
     * @param key   键
     * @param delta 减少的值
     * @return 递减后的值，如果键不存在，则返回-1
     */
    public double decrement(String key, double delta) {
        RAtomicDouble atomicDouble = redissonClient.getAtomicDouble(key);
        return atomicDouble.decrementAndGet();
    }

    public RLock getLock(String key) {
        return redissonClient.getLock(key);
    }

}
