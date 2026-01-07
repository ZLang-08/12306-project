package com.lang.userservice.controller;

import com.lang.userservice.dto.req.UserLoginReqDTO;
import com.lang.userservice.srevice.UserLoginService;

/**
 * 用户登录控制器
 *
 * @Author: lang
 * @Since: 26-01-07 21:10
 */

@RestController
public class UserLoginController {

    private UserLoginService userLoginService;

    @PostMapping("/api/user-service/v1/login")
    public void login(@RequestBody UserLoginReqDTO requestParam) {
        userLoginService.login(requestParam);
    }
}
