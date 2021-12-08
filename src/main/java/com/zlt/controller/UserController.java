package com.zlt.controller;

import com.zlt.pojo.User;
import com.zlt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    //登陆提交
    @RequestMapping("/login")
    public String login(HttpSession session,String name, String password, Model model) throws Exception {
        // 向session记录用户身份信息
        System.out.println("接收前端==="+name);
        User loginUser = userService.queryUser(name, password);
        if(loginUser != null) {//登录成功
            //在会话中注册用户信息，访问首页
            session.setAttribute("user", loginUser);
            return "redirect:/book/allBook";
        }else {//登录失败
            //返回login.jsp,并提示错误消息
            model.addAttribute("errorMsg","账号或密码错误");
            return "index";
        }
    }
    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "index";
    }
}
