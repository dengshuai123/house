package kgc.service;

import com.github.pagehelper.PageInfo;
import kgc.entity.UserCondition;
import kgc.entity.Users;

public interface UserService {
    //查询所有用户
    PageInfo<Users> getUserByPage(UserCondition condition);

    //检查用户名是否存在
    public int checkUname(String username);

    //添加用户  注册
    public int addUser(Users users);

    //实现登入
    public Users login(String username,String password);

}
