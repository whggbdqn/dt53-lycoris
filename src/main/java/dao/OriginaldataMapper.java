package dao;

import entity.Originaldata;

public interface OriginaldataMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Originaldata record);
    int insertSelective(Originaldata record);
    Originaldata selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Originaldata record);
    int updateByPrimaryKeyWithBLOBs(Originaldata record);
    int updateByPrimaryKey(Originaldata record);
}