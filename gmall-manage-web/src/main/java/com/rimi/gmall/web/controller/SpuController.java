package com.rimi.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rimi.gmall.bean.PmsProductInfo;
import com.rimi.gmall.manage.service.SpuServie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 标准商品单元
 *
 * @author Administrator
 * @date 2019/12/29 0029 18:32
 */
@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuServie spuServie;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){

        return spuServie.spuList(catalog3Id);
    }
}
