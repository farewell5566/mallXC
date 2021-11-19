package com.xc.mall.common.api;

public enum ResultCode implements IErrorCode{

    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILER(404,"参数校验失败"),
    UNAUTOORIZED(401,"暂未登录或token已过期"),
    FORBIDDEN(403,"没有相关权限");

    private long code;
    private String message;


    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getCode(){
        return this.code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mess) {
        this.message = mess;
    }


}
