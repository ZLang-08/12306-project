package com.lang.user.Util;

import com.alibaba.fastjson2.JSON;
import com.lang.user.core.UserInfoDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.lang.base.constant.UserConstant.*;

/**
 * JWT 工具类
 *
 * @Author: lang
 * @Since: 2026/1/10
 */
public final class JWTUtil {
    /**
     * 86400 * 1000 为24小时
     */
    private static final long EXPIRATION = 86400;
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String ISS = "index12306";
    public static final String SECRET = "SecretKey039245678901232039487623456783092349288901402967890140939827";

    /**
     * 生成用户 Token, 过期时间为24小时
     * @param userInfo 用户信息
     * @return 用户访问 Token
     */
    public static String generateAccessToken(UserInfoDTO userInfo) {
        Map<String, Object> customerUserMap = new HashMap<>();
        customerUserMap.put(USER_ID_KEY, userInfo.getUserId());
        customerUserMap.put(USER_NAME_KEY, userInfo.getUserName());
        customerUserMap.put(REAL_NAME_KEY, userInfo.getRealName());
        String jwtToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuedAt(new Date())
                .setIssuer(ISS)
                .setSubject(JSON.toJSONString(customerUserMap))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();

        return TOKEN_PREFIX + jwtToken;
    }
}
