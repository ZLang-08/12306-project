package com.lang.convetion.result;

import java.io.Serial;
import java.io.Serializable;

/**
 * 全局返回结果
 *
 * @Author: lang
 * @Since: 2026/1/8
 */


public class Result<T> implements Serializable {

    /**
     * 序列化版本号
     */
    @Serial
    private static final long serialVersionUID = 5679018624309023727L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 成功状态码
     */
    public static final String SUCCESS_CODE = "0";

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
