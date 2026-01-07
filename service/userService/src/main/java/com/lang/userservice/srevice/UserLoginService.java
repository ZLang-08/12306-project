package com.lang.userservice.srevice;

import com.lang.userservice.dto.resp.UserLoginRespDTO;

/**
 * 用户登录服务
 *
 * @Author: lang
 * @Since: 2026/1/7
 */
public interface UserLoginService {

    UserLoginRespDTO login(UserLoginReqDTO requestParam);
}
