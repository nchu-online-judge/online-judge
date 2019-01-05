package com.example.config;

import com.example.shiro.ShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登录的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功跳转的yrl
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //使用 LinkedHashMap 保证添加后有序
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        //定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        //druid 数据源监控界面不拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        //配置退出过滤器，其中具体的退出代码 Shiro 已经帮我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");
        //除以上所有 url 都必须通过认证才可以访问，未通过认证自动访问 loginurl
        //filterChainDefinitionMap.put("/**", "authc");
        //user指的是用户认证通过或者配置了Remember Me记住用户登录状态后可访问。
        filterChainDefinitionMap.put("/**", "user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager() {
        //配置 SecurityManager，并注入 shiroRealm，注意不是DefaultSecurityManager
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());

        //设置 cookie 管理器
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        //shiro生命周期处理器
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "shiroRealm")
    public ShiroRealm shiroRealm() {
        //配置 Realm，需要自己实现
        return new ShiroRealm();
    }

    /**
     * cookie 管理器
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie 加密的密钥，通过AESUtil 获取
        cookieRememberMeManager.setCipherKey(Base64.decode("L7RioUULEFhRyxM7a2R/Yg=="));
        return cookieRememberMeManager;
    }

    /**
     * cookie 对象
     */
    public SimpleCookie rememberMeCookie() {
        //设置 cookie 名称，对应登录界面（login.html）<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //设置cookie的过期时间 这里为一天
        cookie.setMaxAge(60 * 60 * 24);
        return cookie;
    }

}