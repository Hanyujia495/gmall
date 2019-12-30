package com.rimi.gmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rimi.gmall.bean.PmsBaseAttrInfo;
import com.rimi.gmall.bean.PmsBaseAttrValue;
import com.rimi.gmall.manage.service.PmsBaseAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品平台属性
 *
 * @author Administrator
 * @date 2019/12/27 0027 13:32
 */
@Controller
@CrossOrigin
public class AttrController {

    @Reference
    PmsBaseAttrService pmsBaseAttrService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        return pmsBaseAttrService.attrInfoList(catalog3Id);
    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        return pmsBaseAttrService.getAttrValueList(attrId);
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
         pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }




}
