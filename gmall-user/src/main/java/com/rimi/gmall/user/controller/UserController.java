package com.rimi.gmall.user.controller;

import com.rimi.gmall.bean.UmsMember;
import com.rimi.gmall.bean.UmsMemberLevel;
import com.rimi.gmall.bean.UmsMemberReceiveAddress;
import com.rimi.gmall.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户请求的前端控制器，所有的请求都经过他，类似于servlet
 *
 * @author Administrator
 * @date 2019/12/11 0011 9:15
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }

    /**
     * 获取全部会员的信息
     * @return
     */
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers= userService.getAllUser();
        return umsMembers;
    }

    /**
     * 根据会员id获取会员的收货地址
     * @param memberId 会员id
     * @return
     */
    @RequestMapping("getReceiveAddressByMemberID")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberID(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses= userService.getReceiveAddressByMemberID(memberId);
        return umsMemberReceiveAddresses;
    }

/**
     * 根据会员id获取会员的等级
     * @param levelId 会员id
     * @return
     */
    @RequestMapping("getUmsMemberLevel")
    @ResponseBody
    public List<UmsMemberLevel> getLevelByLevelId(String levelId){
        List<UmsMemberLevel> umsMemberLevel= userService.getLevelByLevelId(levelId);
        return umsMemberLevel;
    }





}
