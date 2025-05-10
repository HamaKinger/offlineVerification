package org.freedom.verification.management.controller;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.freedom.verification.management.mapper.UserMapper;
import org.freedom.verification.management.service.UserIDGenerateService;
import org.freedom.verification.po.UserPO;
import org.freedom.verification.util.ConverterUtils;
import org.freedom.verification.vo.Result;
import org.freedom.verification.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 用户管理
 * @author: freedom
 * @date: 2025/5/8
 */
@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserMapper userMapper;
    private final UserIDGenerateService userIDGenerateService;
    @RequestMapping("/createUser")
    @ResponseBody
    public Result<Object> createUser (@RequestBody UserVO userVO) {
        UserPO convert = ConverterUtils.convert(userVO,UserPO.class);
        String userID = userIDGenerateService.generateUserID(userVO.getUserName());
        convert.setId(userID);
        userMapper.insert(convert);
        return Result.success();
    }
}
