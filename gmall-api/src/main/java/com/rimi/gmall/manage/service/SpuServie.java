package com.rimi.gmall.manage.service;

import com.rimi.gmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/29 0029 18:41
 */
public interface SpuServie {
    List<PmsProductInfo> spuList(String catalog3Id);
}
