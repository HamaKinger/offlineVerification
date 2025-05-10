package org.freedom.verification.auth.verification.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.freedom.verification.auth.verification.service.GoogleVerification;
import org.freedom.verification.management.mapper.UserMapper;
import org.freedom.verification.po.UserPO;
import org.freedom.verification.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: google二次认证
 * @author: freedom
 * @date: 2025/5/9
 */
@RestController
@RequestMapping("/google/auth")
@RequiredArgsConstructor
public class GoogleAuthController {
    private final UserMapper userMapper;
    private final GoogleVerification googleVerification;
    @GetMapping("/twoAuth")
    public Result<Object> twoAuth (@RequestParam(name = "username") String username) {
        try {
            QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userName",username);
            UserPO userPO = userMapper.selectOne(queryWrapper);
            String twoAuth = googleVerification.generateSecret(username);
            userPO.setTwoAuth(twoAuth);
            userMapper.updateById(userPO);
            return Result.success(twoAuth);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/authLogin")
    public Result<Object> verification (@RequestParam(name = "username") String username,
                                        @RequestParam(name = "code") String code) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",username);
        UserPO userPO = userMapper.selectOne(queryWrapper);
        try {
            String twoAuth = userPO.getTwoAuth();
            boolean verification = googleVerification.verification(twoAuth,code);
            if(verification){
                StpUtil.login(userPO.getId());
                return Result.success();
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        return Result.failed();
    }
}
