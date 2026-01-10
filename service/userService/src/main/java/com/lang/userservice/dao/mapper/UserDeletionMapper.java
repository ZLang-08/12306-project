package com.lang.userservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lang.userservice.dao.entity.UserDeletionDo;
import org.springframework.stereotype.Component;

/**
 * 用户注销持久层
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
@Component
public interface UserDeletionMapper extends BaseMapper<UserDeletionDo> {
}
