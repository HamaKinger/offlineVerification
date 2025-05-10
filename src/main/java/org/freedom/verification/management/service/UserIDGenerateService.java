package org.freedom.verification.management.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freedom.verification.init.InitCache;
import org.freedom.verification.util.RedisUtils;
import org.redisson.api.RLock;
import org.springframework.stereotype.Service;

/**
 * @description: 用户ID生成服务
 * @author: freedom
 * @date: 2025/5/8
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserIDGenerateService {
    private final RedisUtils redisUtils;

    public String generateUserID(String userName) {
        RLock lock = redisUtils.getLock(userName);
        long increment;
        try {
            lock.lock();
            increment = redisUtils.increment(InitCache.PREFIX_NUMBER, 1);
            return String.valueOf(increment);
        } catch (Exception e) {
            log.error("Failed to generate user ID for user {} due to {}", userName, e.getMessage(), e);
            throw new RuntimeException("Failed to generate user ID", e);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
