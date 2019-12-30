package com.rimi.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rimi.gmall.bean.PmsBaseCatalog1;
import com.rimi.gmall.bean.PmsBaseCatalog2;
import com.rimi.gmall.bean.PmsBaseCatalog3;
import com.rimi.gmall.manage.service.CatalogService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/25 0025 16:19
 */

@Controller
@CrossOrigin
public class CatelogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }


    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }


}
