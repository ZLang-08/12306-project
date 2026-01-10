package com.lang.userservice.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户邮箱表
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_user_mail")
public class UserMailDo {
    /**
     * id
     */
    private Long id;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 注销时间
     */
    private Long deletionTime;
}
