package com.example.shiro;


import com.example.dao.UserDao;
import com.example.doamin.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 获取用户角色和权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    /**
     * 登录验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");

        //通过用户名到数据库查询用户信息
        User user = userDao.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或者密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或者密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已经被锁定，请联系管理员！");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
