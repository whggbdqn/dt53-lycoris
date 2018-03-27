package service;

import entity.Companytoindex;

public interface CompanytoindexService {
	int deleteByPrimaryKey(Integer id);
    int insert(Companytoindex record);
    int insertSelective(Companytoindex record);
    Companytoindex selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Companytoindex record);
    int updateByPrimaryKey(Companytoindex record);
}
