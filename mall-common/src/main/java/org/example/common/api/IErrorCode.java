package org.example.common.api;

/**
 * 封装Api的错误代码
 */
public interface IErrorCode {

    //获取状态码
    long getCode();

    String getMessage();
}
