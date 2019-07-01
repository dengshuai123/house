package kgc.mapper;

import kgc.entity.Type;
import kgc.entity.TypeExample;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    //实现批量删除   //传list集合或者数组都可以
    int deleteMoreType(Integer[] ids);
}