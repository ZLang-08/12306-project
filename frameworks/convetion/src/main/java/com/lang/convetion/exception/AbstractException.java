package com.lang.convetion.exception;

import com.lang.convetion.errorCode.IErrorCode;
import lombok.Getter;

/**
 *抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 *
 * @Author: lang
 * @Since: 2026/1/9
 */
@Getter
public abstract class AbstractException extends RuntimeException {
    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = errorCode.message();
    }
}
