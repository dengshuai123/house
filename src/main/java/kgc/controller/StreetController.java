package kgc.controller;

import com.github.pagehelper.PageInfo;
import kgc.entity.Street;
import kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class StreetController {
     @Autowired
    private StreetService streetService;

     //通过区域找街道
    @RequestMapping("getStreetByDid")
    @ResponseBody
    public Map<String,Object> getUsers(Integer page,Integer rows,Integer did){
        //调用业务
        PageInfo<Street> pageInfo=streetService.getStreetByDistrict(page,rows,did);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
