package com.xc.mall.controller;


import com.xc.mall.common.api.CommonResult;
import com.xc.mall.dto.UmsAdminLoginParam;
import com.xc.mall.mbg.model.UmsAdmin;
import com.xc.mall.mbg.model.UmsPermission;
import com.xc.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "UmsAdminController",description = "后台用户管理")
@Controller
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation(value = "用户注册")
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin ==null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录之后返回token")
    @RequestMapping(value="登录之后返回token",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result){
        String token = umsAdminService.login(umsAdminLoginParam.getUserName(),umsAdminLoginParam.getPassword());
        if (token == null){
            return CommonResult.validateFailed("用户名或秘密错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);

    }

    @ApiOperation(value = "获取用户所有权限")
    @RequestMapping(value = "/permission/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = umsAdminService.getPessmisnList(adminId);
        return CommonResult.success(permissionList);
    }





}
