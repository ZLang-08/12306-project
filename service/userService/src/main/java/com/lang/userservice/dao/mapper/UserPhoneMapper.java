package com.lang.userservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lang.userservice.dao.entity.UserPhoneDo;
import org.springframework.stereotype.Component;

/**
 * 用户手机号持久层
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
@Component
public interface UserPhoneMapper extends BaseMapper<UserPhoneDo> {
}
