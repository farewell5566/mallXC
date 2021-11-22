package com.xc.mall.service;

import com.xc.mall.common.api.CommonResult;


public interface UmsMemberService {

    //创建验证码
    CommonResult generateAuthCode(String telephone);

    //验证验证码和手机
    CommonResult verifyAuthCode(String telephone,String authCode);

}
