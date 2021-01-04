package com.zking.ssm.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("User")
public class UserController {


    @RequestMapping("/login")
    public String login(String username , String password){
        Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken(
                 username,password
         );
        try {
            //将前台传过来的用户和密码和MyRealm里面已经得到数据库的账号和密码，进行比较,如果账号和密码一致就到main.jsp
            subject.login(token);
            return "main";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //如果失败就跳login.jsp
            return "/login.jsp";
        }
    }

    @RequestMapping("/reset")
  @RequiresPermissions("书本管理")
    //@RequiresRoles(value = {"admin"})
    public String toResetPwd(){
        return "resetPwd";
    }

}
