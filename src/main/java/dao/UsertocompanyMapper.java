package dao;

import entity.Usertocompany;

public interface UsertocompanyMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Usertocompany record);
    int insertSelective(Usertocompany record);
    Usertocompany selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Usertocompany record);
    int updateByPrimaryKey(Usertocompany record);
}