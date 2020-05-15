package com.cu.weiketang.service;


import com.cu.weiketang.pojo.User;

/**
 * @ClassName Userservice
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/28 23:23
 **/

public interface UserService {
    /*uaccount 查询user*/
    User selectByUnumber(String unumber)throws Exception;
    /*添加user*/
    int insertUser(User user) throws Exception;
    /*uid查询user*/
    User selectByUid(Integer uid)throws Exception;
}
