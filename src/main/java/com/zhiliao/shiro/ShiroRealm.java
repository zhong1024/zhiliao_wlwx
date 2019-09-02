package com.zhiliao.shiro;

import com.zhiliao.pojo.WlyyUser;
import com.zhiliao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        //String role = userMapper.getRole(username);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add("user:add");
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //1.把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken uPasswordToken = (UsernamePasswordToken) authenticationToken;

        //2.获取username;
        String username = uPasswordToken.getUsername();

        System.out.println("username:"+username);

        WlyyUser wlyyUsers = new WlyyUser();
        wlyyUsers.setName(username);

        //3.调用数据库的方法, 从数据库中查询 username 对应的用户记录
        WlyyUser wlyyUser = userService.login(wlyyUsers);
        //System.out.println("从数据库中获取密码: " + staffInfo.getUserPassowrd() + " 所对应的用户信息.");
        //System.out.println("--------"+new String(uPasswordToken.getPassword()));
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if(wlyyUser == null){
            throw new UnknownAccountException("用户不存在!");
        }

        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.
        Object credentials = wlyyUser.getPassword();
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4. 盐值
        //ByteSource byteSource = ByteSource.Util.bytes(" yangfanrong");

        AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,null, realmName);

        return info;
    }

    public static void main(String[] args) {
        // 加密方法
        String hashAlgorithmName = "MD5";
        // 加密的密码
        Object credentials = "123456";
        // 盐
        Object salt = ByteSource.Util.bytes("yangfanrong");
        // 加密次数
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);

        System.out.println(result);

    }

}