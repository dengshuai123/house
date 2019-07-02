package kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kgc.entity.UserCondition;
import kgc.entity.Users;
import kgc.entity.UsersExample;
import kgc.mapper.UsersMapper;
import kgc.service.UserService;
import kgc.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUserByPage(UserCondition condition) {
        //查询所有
        PageHelper.startPage(condition.getPage(),condition.getRows());
        UsersExample usersExample=new UsersExample();
        //添加条件
        UsersExample.Criteria criteria=usersExample.createCriteria();
        criteria.andIsadminEqualTo(new Integer(1));  //表示管理员
        //添加查询条件
        //添加电话
        if(condition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        //添加姓名
        if(condition.getName()!=null){
            criteria.andNameLike("%"+condition.getName()+"%");
        }

        List<Users> list=usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<Users>(list);
        return pageInfo;
    }

    //检查用户名是否存在
    @Override
    public int checkUname(String username) {
        //写持久化操作
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        //添加条件
        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(0);  //注册用户
        List<Users> users=usersMapper.selectByExample(usersExample);
        return users.size()==0?0:1;
    }

    //添加用户  注册
    @Override
    public int addUser(Users users) {
        //设置为前台注册用户
        users.setIsadmin(0);
        //对用户的密码使用MD5加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    //实现登入
    @Override
    public Users login(String username, String password) {
        //SELECT * FROM users WHERE NAME='wjb' AND PASSWORD='202cb962ac59075b964b07152d234b70'
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        //添加条件
        criteria.andIsadminEqualTo(0);  //注册用户
        criteria.andNameEqualTo(username);
        //加密码
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

        List<Users> users=usersMapper.selectByExample(usersExample);
        if(users.size()==1){
            return users.get(0);
        }
        return null;
    }
}
