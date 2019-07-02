package kgc.controller;

import com.github.pagehelper.PageInfo;
import kgc.entity.HouseExt;
import kgc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("houseController2")
@RequestMapping("/admin/")
public class HouseController {
     @Autowired
     private HouseService houseService;

     //查询未审核
     @RequestMapping("getHouseByNoPass")
     @ResponseBody
    public Map<String,Object> getHouseByNoPass(Integer page,Integer rows){
         PageInfo<HouseExt> pageInfo=houseService.getHouseByState(page,rows,0);  //o表示未审核
         Map<String,Object> map=new HashMap<String,Object>();
         map.put("total",pageInfo.getTotal());
         map.put("rows",pageInfo.getList());
         return map;
     }

    //查询已审核
    @RequestMapping("getHouseByYesPass")
    @ResponseBody
    public Map<String,Object> getHouseByYesPass(Integer page,Integer rows){
        PageInfo<HouseExt> pageInfo=houseService.getHouseByState(page,rows,1);  //o表示未审核
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    //通过审核
    @RequestMapping("passHouse")
    @ResponseBody
    public Map<String,Object> passHouse(String id){
        int temp=houseService.passHouse(id);  //o表示未审核
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result",temp);
        return map;
    }
}
