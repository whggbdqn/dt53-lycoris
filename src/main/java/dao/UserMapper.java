package dao;

import java.util.List;

import entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);//注册
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    
    //查询登录
    List<User> getAllUserPartInfo();
}