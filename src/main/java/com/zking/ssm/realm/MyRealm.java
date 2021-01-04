package com.zking.ssm.realm;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    
    @Autowired
    private IUserService iUserService;

    /**
     * 权限认证 z
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //得到用户的账户
        String username =principalCollection.getPrimaryPrincipal().toString();
        //授权2部分
        // 1.查询角色
        Set<String> roles= iUserService.findRoles(username);
        //2.查询权限
        Set<String> permissions= iUserService.findPermissions(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }


    /**
     * 身份验证 c
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的账号密码
        String  username = authenticationToken.getPrincipal().toString();
        String password = authenticationToken.getCredentials().toString();
        // 通过用户输入的账号得到改账号的所有的信息
        User user = iUserService.login(username);
        if(null==user){
            throw new RuntimeException("未知账号!");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );

        return info;
    }
}
