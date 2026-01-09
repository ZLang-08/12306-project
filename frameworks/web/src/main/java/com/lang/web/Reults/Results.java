package com.lang.web.Reults;

/**
 * 全局返回对象构造器
 *
 * @Author: lang
 * @Since: 2026/1/8
 */
public class Results {

    public static Result<Void> success() {
        return new Result<>(true, null, null);
    }
}
