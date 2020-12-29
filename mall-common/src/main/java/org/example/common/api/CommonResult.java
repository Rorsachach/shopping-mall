package org.example.common.api;

/**
 * 返回常用的返回操作
 */
public class CommonResult<T>{

    private long code;
    private String mesage;
    private T data;

    protected  CommonResult(){

    }

    public CommonResult(long code, String message, T data){
        this.code = code;
        this.mesage = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),
                message,data);
    }

    /**
     * 失败返回结果
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<T>(errorCode.getCode(),
                errorCode.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,
                                             String message){
        return new CommonResult<T>(errorCode.getCode(),
                message,null);
    }

    /**
     * 失败返回结果
     * @param message:错误消息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),
                message,null);
    }

    /**
     * 失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(){
        return  failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(String message){
        return new CommonResult(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }

    /**
     * 登录验证
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(T data){
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),
                ResultCode.UNAUTHORIZED.getMessage(),data);
    }

    /**
     * 授权验证
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),
                ResultCode.FORBIDDEN.getMessage(),data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
