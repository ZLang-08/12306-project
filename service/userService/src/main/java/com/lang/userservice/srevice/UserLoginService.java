package com.lang.userservice.srevice;

import com.lang.userservice.dto.req.UserLoginReqDTO;
import com.lang.userservice.dto.resp.UserLoginRespDTO;

/**
 * 用户登录服务
 *
 * @Author: lang
 * @Since: 2026/1/7
 */
public interface UserLoginService {

    /**
     * 用户登录
     *
     * @param requestParam 请求参数
     * @return 登录结果
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);
}
