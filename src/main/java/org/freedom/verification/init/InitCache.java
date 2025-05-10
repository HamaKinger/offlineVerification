package org.freedom.verification.init;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freedom.verification.management.mapper.SecretMapper;
import org.freedom.verification.po.SecretPO;
import org.freedom.verification.util.RedisUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: freedom
 * @date: 2025/5/9
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitCache implements ApplicationRunner {
    public static final int BASIC_NUMBER = 10000;
    public static final String PREFIX_NUMBER = "FREE_ID_NUMBER";
    private final RedisUtils redisUtils;
    @Override
    public void run (ApplicationArguments args) throws Exception {
        Integer idNumber = redisUtils.get(PREFIX_NUMBER);
        if(idNumber==null){
            log.info("初始化ID开始!:{}",BASIC_NUMBER);
            redisUtils.set(PREFIX_NUMBER,BASIC_NUMBER);
        }
    }
}
