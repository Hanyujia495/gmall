package com.rimi.gmall.user.service.impl;

import com.rimi.gmall.bean.UmsMember;
import com.rimi.gmall.bean.UmsMemberLevel;
import com.rimi.gmall.bean.UmsMemberReceiveAddress;
import com.rimi.gmall.manage.service.UserService;


import com.rimi.gmall.user.mapper.UmsMemberLevelMapper;
import com.rimi.gmall.user.mapper.UmsMenberReceiveAddressMapper;
import com.rimi.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层实现
 *
 * @author Administrator
 * @date 2019/12/11 0011 9:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMenberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Autowired
    UmsMemberLevelMapper umsMemberLevelMapper;


    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList= userMapper.selectAll();
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberID(String userId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(userId);
        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
    }

    @Override
    public List<UmsMemberLevel> getLevelByLevelId(String levelId) {
        UmsMemberLevel umsMemberLevel = new UmsMemberLevel();
        umsMemberLevel.setId(levelId);
        return umsMemberLevelMapper.select(umsMemberLevel);
    }
}
