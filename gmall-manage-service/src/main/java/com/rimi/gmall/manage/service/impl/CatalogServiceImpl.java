package com.rimi.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rimi.gmall.bean.PmsBaseCatalog1;
import com.rimi.gmall.bean.PmsBaseCatalog2;
import com.rimi.gmall.bean.PmsBaseCatalog3;
import com.rimi.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.rimi.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.rimi.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.rimi.gmall.manage.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/25 0025 19:11
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;


    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> select = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        for (PmsBaseCatalog3 baseCatalog3 : select) {
            System.out.println(baseCatalog3);
        }
        return select;
    }

}
