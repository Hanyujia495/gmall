package com.rimi.gmall.manage.service;

import com.rimi.gmall.bean.PmsBaseCatalog1;
import com.rimi.gmall.bean.PmsBaseCatalog2;
import com.rimi.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/25 0025 19:08
 */
public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
