package kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kgc.entity.Street;
import kgc.entity.StreetExample;
import kgc.mapper.StreetMapper;
import kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl  implements StreetService {

    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<Street> getStreetByDistrict(Integer page, Integer pageSize, Integer districtId) {
        PageHelper.startPage(page,pageSize);
        //查询街道
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> list= streetMapper.selectByExample(streetExample);
        return new PageInfo<>(list);
    }

    @Override
    public List<Street> getStreetByDistrict(Integer districtId) {
        //查询街道
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> list= streetMapper.selectByExample(streetExample);
        return list;
    }

}
