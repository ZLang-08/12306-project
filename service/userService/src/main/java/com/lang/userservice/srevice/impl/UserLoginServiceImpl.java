package com.lang.userservice.srevice.impl;

import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lang.convetion.exception.ClientException;
import com.lang.convetion.exception.ServiceException;
import com.lang.user.core.UserInfoDTO;
import com.lang.userservice.dao.entity.UserDo;
import com.lang.userservice.dao.entity.UserMailDo;
import com.lang.userservice.dao.entity.UserPhoneDo;
import com.lang.userservice.dao.mapper.*;
import com.lang.userservice.dto.req.UserLoginReqDTO;
import com.lang.userservice.dto.resp.UserLoginRespDTO;
import com.lang.userservice.srevice.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户登录服务实现类
 *
 * @Author: lang
 * @Since: 2026/1/7
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMailMapper userMailMapper;

    @Autowired
    private UserPhoneMapper userPhoneMapper;

    @Autowired
    private UserReuseMapper userReuseMapper;

    @Autowired
    private UserDeletionMapper userDeletionMapper;






    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        String usernameOrMailOrPhone = requestParam.getUsernameOrMailOrPhone();
        boolean isMail = usernameOrMailOrPhone.contains("@");
        String userName;
        if (isMail) {
            LambdaQueryWrapper<UserMailDo> queryWrapper = Wrappers.lambdaQuery(UserMailDo.class)
                    .eq(UserMailDo::getMail, usernameOrMailOrPhone);
            userName = Optional.ofNullable(userMailMapper.selectOne(queryWrapper))
                    .map(UserMailDo::getUserName)
                    .orElseThrow(() -> new ClientException("用户/手机号/邮箱不存在"));
        } else {
            LambdaQueryWrapper<UserPhoneDo> queryWrapper = Wrappers.lambdaQuery(UserPhoneDo.class)
                    .eq(UserPhoneDo::getPhone, usernameOrMailOrPhone);
            userName = Optional.ofNullable(userPhoneMapper.selectOne(queryWrapper))
                    .map(UserPhoneDo::getUserName)
                    .orElse(null);
        }
        userName = Optional.ofNullable(userName)
                .orElse(usernameOrMailOrPhone);
        LambdaQueryWrapper<UserDo> queryWrapper = Wrappers.lambdaQuery(UserDo.class)
                .eq(UserDo::getUserName, userName)
                .eq(UserDo::getPassword, requestParam.getPassword())
                .select(UserDo::getId, UserDo::getUserName, UserDo::getRealName);
        UserDo userDo = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isNotNull(userDo)) {
            UserInfoDTO userInfo = UserInfoDTO.builder()
                    .userId(String.valueOf(userDo.getId()))
                    .userName(userDo.getUserName())
                    .realName(userDo.getRealName())
                    .build();
            // TODO : 生成token
            String accessToken = "JWTUtil";
            UserLoginRespDTO actual = new UserLoginRespDTO(userInfo.getUserId(), usernameOrMailOrPhone, userDo.getRealName(), accessToken);

        }
        throw new ServiceException("用户不存在或密码错误");
    }
}
