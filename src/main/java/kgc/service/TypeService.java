package kgc.service;

import com.github.pagehelper.PageInfo;
import kgc.entity.Type;

import java.util.List;

public interface TypeService {

    //查询全部的户型
    List<Type> getAllType();

    //查询区域带分页
    PageInfo<Type> getTypeByPage(Integer page, Integer pageSize);

    /**
     * 添加区域
     * @param type
     * @return
     */
    public int addType(Type type);


    /**
     * 修改区域
     * @param
     * @return
     */
    public int updateType(Type type);


    /**
     * 删除区域
     * @param
     * @return
     */
    public int deleteType(Integer id);

    /**
     *
     * @param ids
     * @return
     */
    int deleteMoreType(Integer[] ids);
}
