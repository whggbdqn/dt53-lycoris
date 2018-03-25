package dao;

import entity.Companytoindex;

public interface CompanytoindexMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Companytoindex record);
    int insertSelective(Companytoindex record);
    Companytoindex selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Companytoindex record);
    int updateByPrimaryKey(Companytoindex record);
}