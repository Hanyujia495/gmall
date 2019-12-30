package com.rimi.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rimi.gmall.bean.PmsBaseAttrInfo;
import com.rimi.gmall.bean.PmsBaseAttrValue;
import com.rimi.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.rimi.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.rimi.gmall.manage.service.PmsBaseAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 平台属性和值的服务实现类
 *
 * @author Administrator
 * @date 2019/12/27 0027 13:53
 */
@Service
public class PmsBaseAttrServiceImpl implements PmsBaseAttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }

    /**
     * 通过封装的属性和属性值对象存储到数据库
     *
     * @param pmsBaseAttrInfo
     * @return
     */
    @Override
    public Boolean saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        List<PmsBaseAttrValue> pmsBaseAttrValues =pmsBaseAttrInfo.getAttrValueList();
        //修改平台属性
        if (pmsBaseAttrInfoMapper.existsWithPrimaryKey(pmsBaseAttrInfo.getId())){
            pmsBaseAttrInfoMapper.delete(pmsBaseAttrInfo);
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);
            return saveAttr(pmsBaseAttrInfo);
            //添加平台属性
        }else {
            return saveAttr(pmsBaseAttrInfo);
        }
    }

    /**
     * 根据传来的平台属性存储到数据库
     * @param pmsBaseAttrInfo
     * @return
     */
    private Boolean saveAttr(PmsBaseAttrInfo pmsBaseAttrInfo){
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        int insert1 = pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
        PmsBaseAttrInfo pmsBaseAttrInfo1 = pmsBaseAttrInfoMapper.selectOne(pmsBaseAttrInfo);
        int insert2=0;
        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo1.getId());
            insert2+=pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
        }
        if(insert1+insert2==attrValueList.size()+1){
            return true;
        }else {
            return false;
        }
    }
}
