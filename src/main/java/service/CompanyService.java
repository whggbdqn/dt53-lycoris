package service;

import java.util.List;

import entity.Company;
import pojo.AreatoCompany;

public interface CompanyService {
	 int deleteByPrimaryKey(Integer id);
	    int insert(Company record);
	    int insertSelective(Company record);
	    Company selectByPrimaryKey(Integer id);
	    int updateByPrimaryKeySelective(Company record);
	    int updateByPrimaryKeyWithBLOBs(Company record);
	    int updateByPrimaryKey(Company record);
	    int checkCompanyName(String companyName);
	    /**
	     * 查询地区公司
	     * @return	地区有多少家公司集合
	    */
	    List<AreatoCompany> getAllAreabyCompany();
	    /**
	     * 设置处理后数据记录时间
	     * @author ss
	     * @date 2018/3/27
	     * 
	     */
	    void setTime(String time);
}
