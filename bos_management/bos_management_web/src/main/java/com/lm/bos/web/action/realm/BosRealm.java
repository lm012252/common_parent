package com.lm.bos.web.action.realm;

import com.lm.bos.dao.system.IUserDao;
import com.lm.bos.domain.system.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class BosRealm extends AuthorizingRealm {

    @Resource
    private IUserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //去除当前用户的token
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        //通过用户名查询数据库中用户是否存在
        String username = usernamePasswordToken.getUsername();
        //String password = usernamePasswordToken.getPassword().toString();
        User user = userDao.findByUsername(username);

        if(user==null){
            return null;
        }
        /*通过shiro框架本身自带的认证方法去进行密码校验   user:当前从数据库查询用户对象  凭证：密码(后台数据库查询的密码)
        getNeme：当前自定义realm对象

        根据用户名到数据库只查询用户对象   通过SimpleAuthenticationInfo对象进行封装传给shiro框架进行认证*/

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
    }
}
