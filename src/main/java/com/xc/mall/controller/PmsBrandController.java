package com.xc.mall.controller;


import com.github.pagehelper.PageInfo;
import com.xc.mall.common.api.CommonPage;
import com.xc.mall.common.api.CommonResult;
import com.xc.mall.mbg.model.PmsBrand;
import com.xc.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @ResponseBody
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("新建品牌")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult createBand(@RequestBody PmsBrand brand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(brand);
        if (count == 1) {
            commonResult = CommonResult.success(brand);
            LOGGER.debug("CreateBrand success:{}", brand);
        } else {
            commonResult = CommonResult.failed(brand);
            LOGGER.debug("create Brand error:", brand);
        }

        return commonResult;
    }

    @ApiOperation("更新指定ID品牌信息")
    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult<PmsBrand> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmdBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmdBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmdBrandDto);
            LOGGER.debug("update success:", pmdBrandDto);
        } else {
            commonResult = CommonResult.failed(pmdBrandDto);
            LOGGER.debug("update failed", id);
        }
        return commonResult;
    }

    @ApiOperation("删除指定ID品牌信息")
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> deleteBrand(@PathVariable("id") Long id) {
        CommonResult<PmsBrand> commonResult;
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            commonResult = CommonResult.success(null);
            LOGGER.debug("删除成功，", id);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("删除失败{}", id);
        }
        return commonResult;
    }

    @ApiOperation("分页查询品牌列表信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand (@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                @RequestParam(value="pageSize",defaultValue = "5")Integer pageSize){
        List<PmsBrand>brandList = pmsBrandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("查询指定ID品牌的商品")
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public CommonResult<PmsBrand> brand(@PathVariable("id")Long id){
        PmsBrand pmsBrand = pmsBrandService.getBrand(id);
        return CommonResult.success(pmsBrand);
    }
















}
