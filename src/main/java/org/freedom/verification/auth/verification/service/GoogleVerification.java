package org.freedom.verification.auth.verification.service;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: 二次验证生成
 * @author: freedom
 * @date: 2025/5/9
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GoogleVerification {
    private final GoogleAuthenticator google;

    public boolean verification (String secret,String code) {
        return google.authorize(secret, Integer.parseInt(code));
    }
    public String generateSecret (String userName) {
        try {
            return google.createCredentials(userName).getKey();
        } catch (Exception e) {
            log.error("Failed to generate secret for user {} due to {}", userName, e.getMessage(), e);
            throw new RuntimeException("Failed to generate secret", e);
        }
    }
}
