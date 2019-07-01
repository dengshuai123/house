package kgc.service;

import com.github.pagehelper.PageInfo;
import kgc.entity.District;

import java.util.List;

public interface DistrictService {

    //查询全部的区域
    List<District> getAllDistrict();

    //查询区域带分页
    PageInfo<District> getDistrictByPage(Integer page, Integer pageSize);

    /**
     * 添加区域
     * @param district
     * @return
     */
    public int addDistrict(District district);


    /**
     * 修改区域
     * @param district
     * @return
     */
    public int updateDistrict(District district);


    /**
     * 删除区域
     * @param  id
     * @return
     */
    public int deleteDistrict(Integer id);

    /**
     *
     * @param ids
     * @return
     */
    int deleteMoreDistrict(Integer[] ids);
}
