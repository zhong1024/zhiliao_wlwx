package com.zhiliao.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ShiroConfig.class);

    //用于thymeleaf模板使用shiro标签
    @Bean
    public ShiroDialect shiroDialect() {
        logger.info("shiro标签");
        return new ShiroDialect();
    }


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件过滤器
     * </br>1,配置shiro安全管理器接口securityManage;
     * </br>2,shiro 连接约束配置filterChainDefinitions;
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            SecurityManager securityManager) {

        //shiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 配置shiro安全管理器 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 指定要求登录时的链接
        shiroFilterFactoryBean.setLoginUrl("/login.arr");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/instance.arr");
        // 未授权时跳转的界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        // filterChainDefinitions拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 从上向下顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/plugins/login", "anon");
        filterChainDefinitionMap.put("/plugins/index", "anon");
        filterChainDefinitionMap.put("/plugins/index1", "anon");
        filterChainDefinitionMap.put("/plugins/welcome", "anon");
        filterChainDefinitionMap.put("/lib", "anon");
        filterChainDefinitionMap.put("/index", "authc,roles[user:add]");

        // 配置退出过滤器,具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问【放行】-->
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.info("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    /**
     * shiro安全管理器设置realm认证
     *
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRememberMeManager(null);
        // 设置realm.
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 身份认证realm; (账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    /**
     * @Description: Shiro生命周期，保证实现了Shiro内部lifecycle函数的bean执行     * @Param: []     * @return: org.apache.shiro.spring.LifecycleBeanPostProcessor     * @Author: ywj     * @Date: 2019/3/28 0028
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /*
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        logger.info("加密");
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，比如散列两次，相当于md5(md5(""));
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

}