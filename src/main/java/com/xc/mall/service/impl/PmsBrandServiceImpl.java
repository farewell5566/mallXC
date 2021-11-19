package com.xc.mall.service.impl;

import com.xc.mall.mbg.mapper.PmsBrandMapper;
import com.xc.mall.mbg.model.PmsBrand;
import com.xc.mall.service.PmsBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return null;
    }

    @Override
    public int creaeBrand(PmsBrand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(long id) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return null;
    }
}
