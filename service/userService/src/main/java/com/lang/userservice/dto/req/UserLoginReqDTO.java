package com.lang.userservice.dto.req;

/**
 * 用户登录请求参数
 *
 * @Author: lang
 * @Since: 21:31
 */

public class UserLoginReqDTO {



    /**
     * 用户名或邮箱或手机号
     */
    private String usernameOrMailOrPhone;

    /**
     * 密码
     */
    private String password;

    public String getUsernameOrMailOrPhone() {
        return usernameOrMailOrPhone;
    }

    public void setUsernameOrMailOrPhone(String usernameOrMailOrPhone) {
        this.usernameOrMailOrPhone = usernameOrMailOrPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
