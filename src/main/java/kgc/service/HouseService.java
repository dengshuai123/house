package kgc.service;

import com.github.pagehelper.PageInfo;
import kgc.entity.House;
import kgc.entity.HouseExt;

public interface HouseService {
    //添加出租房
    public  int addHouse(House house);

    //查询用户的出租房
    public PageInfo<HouseExt> getUserHouseByPage(Integer page, Integer rows, Integer uid);

    //查询单条
    public HouseExt upShowHouse(String id);

    //修改出租房信息
    public int updateHouse(House house);

    //删除出租房信息
    public int delHouse(String id);

    //查询审核的出租房
    PageInfo<HouseExt> getHouseByState(Integer page, Integer rows, int i);

    //审核出租房
    int passHouse(String id);
}
