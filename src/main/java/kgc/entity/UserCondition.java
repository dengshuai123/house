package kgc.entity;

public class UserCondition {
    //分页
    private Integer page;  //页码
    private Integer rows;  //页大小

    //条件属性
    private String telephone;  //电话
    private String name;
    //private Integer startAge;  //开始年龄
    //private  Integer endAge;  //结束年龄

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
