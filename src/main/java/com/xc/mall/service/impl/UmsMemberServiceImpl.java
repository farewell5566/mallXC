package com.xc.mall.service.impl;

import com.xc.mall.common.api.CommonResult;
import com.xc.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    RedisServiceImpl redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTHCODE;

    @Value("${redis.key.expire.authCode}")
    private long REDIS_KEY_EXPIRE_AUTHCODE;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random =new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        redisService.set(REDIS_KEY_PREFIX_AUTHCODE+telephone,stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTHCODE+telephone,REDIS_KEY_EXPIRE_AUTHCODE);

        return CommonResult.success(stringBuilder.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (authCode.isEmpty()) return CommonResult.failed("请输入验证码");

        if (redisService.get(REDIS_KEY_PREFIX_AUTHCODE + telephone).equals(authCode)){
            return CommonResult.success(null,"验证成功");
        }else{
            return CommonResult.failed("验证失败");
        }

    }
}
