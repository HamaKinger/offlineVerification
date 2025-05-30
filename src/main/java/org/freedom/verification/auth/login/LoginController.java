package org.freedom.verification.auth.login;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freedom.verification.auth.verification.service.GoogleVerification;
import org.freedom.verification.management.mapper.SecretMapper;
import org.freedom.verification.management.mapper.UserMapper;
import org.freedom.verification.po.SecretPO;
import org.freedom.verification.po.UserPO;
import org.freedom.verification.util.I18nUtil;
import org.freedom.verification.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 登录管理
 * @author: freedom
 * @date: 2025/5/9
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserMapper userMapper;
    private final GoogleVerification googleVerification;
    private final SecretMapper secretMapper;

    @GetMapping("/login")
    public Result<Object> login (@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",username);
        SecretPO secretPO = secretMapper.selectById("ps");
        UserPO userPO = userMapper.selectOne(queryWrapper);
        try {
            String pwd = userPO.getPassWord();
            String decrypt = SaSecureUtil.aesDecrypt(secretPO.getSecretKey(),pwd);
            if(decrypt.equals(password)){
                userPO.setPassWord(null);
                StpUtil.login(userPO.getId());
                return Result.success(userPO);
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        return Result.failed();
    }
    @GetMapping("/local")
    public Result<Object> local () {
        return Result.success(I18nUtil.getMessage("A00001","123"));
    }
}
