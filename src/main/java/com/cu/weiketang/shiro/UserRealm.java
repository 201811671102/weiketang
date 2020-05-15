package com.cu.weiketang.shiro;

import com.cu.weiketang.pojo.User;
import com.cu.weiketang.redis.RedisUtil;
import com.cu.weiketang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = new User();
        try {
            if (redisUtil.hasKey(token.getUsername())){
                user = (User) redisUtil.get("weiketang"+token.getUsername());
            }else{
                user = userService.selectByUnumber(token.getUsername());
                redisUtil.set("weiketang"+token.getUsername(),user);
            }
            if (user==null){
                return null;
            }
        }catch (Exception e){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getUpassword(),getName());
    }
}
