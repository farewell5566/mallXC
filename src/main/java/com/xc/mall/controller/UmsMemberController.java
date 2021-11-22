package com.xc.mall.controller;

import com.xc.mall.common.api.CommonResult;
import com.xc.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sso")
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;

    @ApiOperation("获取手机验证码")
    @ResponseBody
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    public CommonResult<String> getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证手机验证码是否正确")
    @ResponseBody
    @RequestMapping(value = "/vaildAuthCode",method = RequestMethod.GET)
    public CommonResult<String> vaildAuthCode(@RequestParam String telephone,@RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }



}
