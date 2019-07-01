package kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kgc.entity.House;
import kgc.entity.HouseExt;
import kgc.mapper.HouseMapper;
import kgc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<HouseExt> getUserHouseByPage(Integer page, Integer rows, Integer uid) {
        PageHelper.startPage(page,rows);
        //调用dao层查询出租房
        List<HouseExt> list=houseMapper.selectHouseByUserId(uid);
        //创建pageInfo
        return new PageInfo<HouseExt>(list);
    }

    @Override
    public HouseExt upShowHouse(String id) {
        return houseMapper.upShowHouse(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //逻辑删除
    @Override
    public int delHouse(String id) {
        House house=new House();
        house.setId(id);
        //删除
        house.setIsdel(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //未审核房屋
    @Override
    public PageInfo<HouseExt> getHouseByState(Integer page, Integer rows, int i) {
        PageHelper.startPage(page,rows);
        //调用dao层查询出租房
        List<HouseExt> list=houseMapper.getHouseByState(i);
        //创建pageInfo
        return new PageInfo<HouseExt>(list);
    }

    //审核房屋
    @Override
    public int passHouse(String id) {
        House house=new House();
        house.setId(id);
        //删除
        house.setIspass(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }
}
