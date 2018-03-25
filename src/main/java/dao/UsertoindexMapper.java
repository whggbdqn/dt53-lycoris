package dao;

import entity.Usertoindex;

public interface UsertoindexMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Usertoindex record);
    int insertSelective(Usertoindex record);
    Usertoindex selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Usertoindex record);
    int updateByPrimaryKey(Usertoindex record);
}