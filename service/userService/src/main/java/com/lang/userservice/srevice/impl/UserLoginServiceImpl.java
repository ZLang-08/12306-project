package com.lang.userservice.srevice.impl;

import com.lang.userservice.dto.req.UserLoginReqDTO;
import com.lang.userservice.dto.resp.UserLoginRespDTO;
import com.lang.userservice.srevice.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户登录服务实现类
 *
 * @Author: lang
 * @Since: 2026/1/7
 */
public class UserLoginServiceImpl implements UserLoginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {

        return null;
    }
}
