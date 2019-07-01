package kgc.mapper;

import kgc.entity.House;
import kgc.entity.HouseExample;
import kgc.entity.HouseExt;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //显示用户出租房信息
    List<HouseExt> selectHouseByUserId(Integer uid);

    //查询单条
    HouseExt upShowHouse(String id);

    /**
     * 查询审核出租房信息
     * @param state state=0 表示查询所有未审核  1 表示查询所有已审核
     * @return
     */
    List<HouseExt> getHouseByState(Integer state);
}