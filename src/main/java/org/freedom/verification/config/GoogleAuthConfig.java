package org.freedom.verification.config;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.ICredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: google离线验证码
 * @author: freedom
 * @date: 2025/5/9
 */
@Configuration
@Slf4j
public class GoogleAuthConfig {

    @Bean
    @ConditionalOnMissingBean(GoogleAuthenticator.class)
    public GoogleAuthenticator googleAuthenticator () {
        // 创建 GoogleAuthenticator 实例
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        // 设置凭证仓库
        ICredentialRepository credentialRepository = new InMemoryCredentialRepository();
        gAuth.setCredentialRepository(credentialRepository);
        return gAuth;
    }

    // 简单的内存实现 ICredentialRepository
    static class InMemoryCredentialRepository implements ICredentialRepository {
        private final Map<String, String> userKeys = new HashMap<>();

        @Override
        public String getSecretKey (String userName) {
            return userKeys.get(userName);
        }

        @Override
        public void saveUserCredentials (String userName,String key,int i,List<Integer> list) {
            userKeys.put(userName, key);
        }
    }
}
