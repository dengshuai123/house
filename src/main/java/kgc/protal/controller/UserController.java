package kgc.protal.controller;

import kgc.entity.Users;
import kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {
    @Autowired
    private UserService userService;

    //注册名字是否重复查询
    @RequestMapping("checkUname")
    @ResponseBody
    public String checkUname(String name){
       //调用业务
        int temp=userService.checkUname(name);
        return "{\"result\":"+temp+"}";  //返回json
    }

    //注册
    @RequestMapping("regUser")
    public String regUser(Users users){
        //调用业务
        int temp=userService.addUser(users);
        if(temp>0)
        return "page/login";
        else
            return "page/error";
    }

    //登录
    @RequestMapping("login")
    public String regUser(String name, String password, Model model, HttpSession session){
        //调用业务
        Users user=userService.login(name,password);
        if(user==null) {
            model.addAttribute("info","用户名密码错误!");
            return "page/login";  //继续登入
        }
        else {
            //只要登入:使用session或者cookie保存登入的信息
           session.setAttribute("user",user);
           session.setMaxInactiveInterval(600); //30秒
           return "page/guanli";  //用户中心的管理页
        }
    }
}
