package com.xc.mall.service;

import com.xc.mall.mbg.model.UmsAdmin;
import com.xc.mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    UmsAdmin getAdminByUsername(String userName);

    List<UmsPermission> getPessmisnList(Long id);

    /**
     * 登录返回token
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);


}
