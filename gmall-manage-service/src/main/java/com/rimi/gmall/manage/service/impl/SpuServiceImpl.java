package com.rimi.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rimi.gmall.bean.PmsProductInfo;
import com.rimi.gmall.manage.mapper.PmsProductInfoMapper;
import com.rimi.gmall.manage.service.SpuServie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/29 0029 18:42
 */
@Service
public class SpuServiceImpl implements SpuServie {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return pmsProductInfoMapper.selectAll();
    }
}
