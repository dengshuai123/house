package kgc.mapper;

import kgc.entity.Street;
import kgc.entity.StreetExample;

import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //根据区域删除街道
    void deleltStreetByDid(Integer id);
}