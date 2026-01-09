package com.lang.web.Reults;

import com.lang.convetion.errorCode.BaseErrorCode;
import com.lang.convetion.exception.AbstractException;
import com.lang.convetion.result.Result;

import java.util.Optional;

/**
 * 全局返回对象构造器
 *
 * @Author: lang
 * @Since: 2026/1/8
 */
public class Results {

    /**
     * 创建一个成功返回结果
     *
     * @return 成功返回结果
     */
    public static Result<Void> success() {
        return new Result<Void>().setCode(Result.SUCCESS_CODE);
    }

    /**
     * 创建一个成功返回结果
     *
     * @param data 返回数据
     * @return 带数据的成功返回结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(Result.SUCCESS_CODE).setData(data);
    }

    /**
     * 创建一个带消息的成功返回结果
     * @param message 提示信息
     * @param data 返回数据
     * @return 带消息和数据的成功返回结果
     * @param <T> 返回数据类型
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<T>().setCode(Result.SUCCESS_CODE).setMessage(message).setData(data);
    }

    /**
     * 创建一个服务端失败响应
     *
     * @return 失败返回结果
     */
    protected static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCode.SERVICE_ERROR.code())
                .setMessage(BaseErrorCode.SERVICE_ERROR.message());

    }

    /**
     * 根据错误码构建失败响应
     *
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @return 带错误码和错误信息的失败返回结果
     */
    protected static Result<Void> failure(String errorCode, String errorMsg) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMsg);
    }

    /**
     * 根据 {@link AbstractException} 异常构建失败响应
     *
     * @param abstractException 异常
     * @return 带错误码和错误信息的失败返回结果
     */
    protected static Result<Void> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
                .orElse(BaseErrorCode.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
                .orElse(BaseErrorCode.SERVICE_ERROR.message());
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

}
