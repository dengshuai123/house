package kgc.mapper;

import kgc.entity.District;
import kgc.entity.DistrictExample;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

    //批量删除
    int deleteMoreDistrict(Integer[] ids);
}