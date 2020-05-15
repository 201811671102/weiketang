package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.UserMapper;
import com.cu.weiketang.pojo.User;
import com.cu.weiketang.pojo.UserExample;
import com.cu.weiketang.redis.RedisUtil;
import com.cu.weiketang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/28 23:24
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User selectByUnumber(String unumber) throws Exception {
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUnumberEqualTo(unumber);
            return userMapper.selectByExample(userExample).get(0);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public int insertUser(User user) throws Exception {
        redisUtil.set("weiketang"+user.getUnumber(),user);
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByUid(Integer uid) throws Exception {
        return userMapper.selectByPrimaryKey(uid);
    }
}
