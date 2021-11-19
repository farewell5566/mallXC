package com.xc.mall.controller;


import com.xc.mall.common.api.CommonResult;
import com.xc.mall.mbg.model.PmsBrand;
import com.xc.mall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ResponseBody
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public CommonResult createBand(@RequestBody PmsBrand brand){
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(brand);
        if (count == 1){
            LOGGER.debug("CreateBrand success:{}",brand);
            commonResult = CommonResult.success(brand);
        }else{
            LOGGER.debug("create Brand error:",brand);
            commonResult = CommonResult.failed(brand);
        }

        return commonResult;
    }






}
