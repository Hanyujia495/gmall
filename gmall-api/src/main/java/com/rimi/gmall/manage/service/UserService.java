package com.rimi.gmall.manage.service;

import com.rimi.gmall.bean.UmsMember;
import com.rimi.gmall.bean.UmsMemberLevel;
import com.rimi.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 用户的业务层接口
 *
 * @author Administrator
 * @date 2019/12/11 0011 9:17
 */
public interface UserService {
    /**
     * 获取全部用户信息
     * @return 用户列表
     */
     List<UmsMember> getAllUser();

    /**
     * 根据用户id获取用户收货地址
     * @param userId 用户id
     * @return 用户地址列表
     */
     List<UmsMemberReceiveAddress> getReceiveAddressByMemberID(String userId);

    /**
     * 根据用户等级获取用户等级信息
     * @param memberId
     * @return 会员等级信息
     */

    List<UmsMemberLevel> getLevelByLevelId(String memberId);
}
