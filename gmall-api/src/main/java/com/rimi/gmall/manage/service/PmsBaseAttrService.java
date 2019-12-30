package com.rimi.gmall.manage.service;

import com.rimi.gmall.bean.PmsBaseAttrInfo;
import com.rimi.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/27 0027 13:52
 */
public interface PmsBaseAttrService {
    /**
     * 通过第三级分类获得平台属性列表
     * @param catalog3Id
     * @return
     */
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    /**
     * 通过属性id获取该属性的属性值
     * @param attrId
     * @return
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    /**
     * 通过封装的属性和属性值对象存储到数据库
     * @param pmsBaseAttrInfo
     * @return
     */
    Boolean saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
