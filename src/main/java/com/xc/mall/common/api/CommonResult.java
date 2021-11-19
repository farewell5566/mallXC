package com.xc.mall.common.api;

import com.fasterxml.jackson.databind.JsonSerializer;

public class CommonResult<T> {
    private long code;
    private String message;
    private T data;


    protected CommonResult(){}

    protected CommonResult(Long code,String message,T data){
        this.code = code;
        this.message = message ;
        this.data = data;
    }

    //成功返回结果
    public static <T> CommonResult<T>success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    //成功返回信息
    public static <T>CommonResult<T> success(T data,String message){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
    }

    //失败返回结果
    public static <T> CommonResult<T>failed(T data){
        return new CommonResult<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),data);
    }
    //失败返回编码

    public static <T> CommonResult<T> failed(IErrorCode errCode){
        return new CommonResult<T>(errCode.getCode(),errCode.getMessage(), null);
    }


    public static <T> CommonResult<T> failed(){
        return  failed(ResultCode.FAILED);
    }
    //验证失败，返回结果

    public static <T> CommonResult<T>validateFailed(){
        return failed(ResultCode.VALIDATE_FAILER);
    }

    public static <T>CommonResult<T>validateFailed(String message){
        return new CommonResult<T>(ResultCode.VALIDATE_FAILER.getCode(),message,null);
    }

    //未登录返回结果
    public static <T> CommonResult<T>unauthorizedFailed(){
        return failed(ResultCode.UNAUTOORIZED);
    }

    //未授权返回结果
    public static <T> CommonResult<T>forbidden(T data){
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
    }

}
