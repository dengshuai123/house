package kgc.controller;

import com.github.pagehelper.PageInfo;
import kgc.entity.UserCondition;
import kgc.entity.Users;
import kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UsersController {
     @Autowired
    private UserService userService;

    @RequestMapping("getUsers")
    @ResponseBody
    public Map<String,Object> getUsers(UserCondition condition){
        //调用业务
        PageInfo<Users> pageInfo=userService.getUserByPage(condition);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
