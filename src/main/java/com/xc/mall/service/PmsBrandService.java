package com.xc.mall.service;

import com.xc.mall.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id,PmsBrand brand);

    int deleteBrand(long id);

    List<PmsBrand>listBrand(int pageNum,int pageSize);

    PmsBrand getBrand(Long id);

}
