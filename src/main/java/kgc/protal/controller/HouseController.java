package kgc.protal.controller;

import com.github.pagehelper.PageInfo;
import kgc.entity.*;
import kgc.service.DistrictService;
import kgc.service.HouseService;
import kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class HouseController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private HouseService houseService;


    @RequestMapping("goFaBu")
    public String goFaBu(Model model){
        //获取全部的类型
        List<Type> types = typeService.getAllType();
        //获取全部的区域
        List<District> districts = districtService.getAllDistrict();

        //通过模型传递数据
        model.addAttribute("types",types);
        model.addAttribute("districts",districts);

        return "page/fabu";
    }

    @RequestMapping("addHouse")
    public String addHouse(House house, @RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws  Exception{
        //将文件保存在服务器中  D:\\images

        String fname=pfile.getOriginalFilename();
        String expName=fname.substring(fname.lastIndexOf("."));
        String saveName=System.currentTimeMillis()+expName; //保存文件名
        File file=new File("D:\\images\\"+saveName);
        pfile.transferTo(file);  //保存

        //保存数据库的记录  house已经接收部分表单数据
        //设置编号
        house.setId(System.currentTimeMillis()+"");
        //设置用户编号
        Users user=(Users)session.getAttribute("user");
        house.setUserId(user.getId());
        //设置审核状态 0  如果表中有默认值 可不设
        house.setIspass(0);
        //设置是否删除  0
        house.setIsdel(0);
        //设置图片路径
        house.setPath(saveName);

        if(houseService.addHouse(house)>0){ //保存数据
            //调用业务
            //houseService.addHouse(house); //添加信息到数据库
            return "redirect:goFaBu";  //跳转页面
        }
        else{
            //成功上传的图片删除
            //file.delete();
            return "redirect:goFaBu";  //跳转页面
        }
    }

    @RequestMapping("getUserHouse")
    public String getUserHouse(Model model,Integer page,HttpSession session){
        //得到uid
        //设置用户编号
        Users user=(Users)session.getAttribute("user");
        Integer uid = user.getId();
        //调用业务层
        PageInfo<HouseExt> houseExtPageInfo = houseService.getUserHouseByPage(page==null?1:page, 2, uid);
        //将数据放到域中进行传递
        model.addAttribute("houseExtPageInfo",houseExtPageInfo);

        return "page/guanli";
    }

    @RequestMapping("upShowHouse")
    public String upShowHouse(Model model,String id){
        //查询所有类型
        List<Type> types=typeService.getAllType();
        //查询所有区域
        List<District> districts=districtService.getAllDistrict();
        //调用业务层
        HouseExt houseExt = houseService.upShowHouse(id);
        //将数据放到域中进行传递
        model.addAttribute("houseExt",houseExt);
        model.addAttribute("types",types);
        model.addAttribute("districts",districts);

        return "page/upfabu";
    }

    @RequestMapping("upHouse")
    public String upHouse(String oldPic,House house, @RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws  Exception{
        //1.修改时判断用户有没有修改图片
        File file=null;
        String fname=pfile.getOriginalFilename();
        String expName=fname.substring(fname.lastIndexOf("."));
        String saveName=System.currentTimeMillis()+expName; //保存文件名
        if(!pfile.getOriginalFilename().equals("")){
            //删除旧的图片
            file=new File("D:\\images\\"+oldPic);
            file.delete();
            //System.out.println("修改图片");
            //上传新的图片，设置path为上传新的图片名称
            file=new File("D:\\images\\"+saveName);
            pfile.transferTo(file);  //保存
            //设置图片名称
            house.setPath(saveName);
        }

        //保存数据库的记录  house已经接收部分表单数据
        //设置编号
        //house.setId(System.currentTimeMillis()+"");
        //设置用户编号
        //Users user=(Users)session.getAttribute("user");
        //house.setUserId(user.getId());
        //设置审核状态 0  如果表中有默认值 可不设
        //house.setIspass(0);
        //设置是否删除  0
        //house.setIsdel(0);
        //设置图片路径
        house.setPath(saveName);

        if(houseService.updateHouse(house)<=0){
            //成功上传的图片删除
            if(file!=null) file.delete();
        }
        return "redirect:getUserHouse";//跳转页面
    }

    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(Model model,String id){
        //调用业务层
        int temp = houseService.delHouse(id);

        return "{\"result\":"+temp+"}";
    }
}
