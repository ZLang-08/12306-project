package com.lang.userservice.controller;

import com.lang.convetion.result.Result;
import com.lang.userservice.dto.req.UserLoginReqDTO;
import com.lang.userservice.dto.resp.UserLoginRespDTO;
import com.lang.userservice.srevice.UserLoginService;
import com.lang.web.Reults.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userLoginService.login(requestParam));
    }
}
