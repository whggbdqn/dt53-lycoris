package service;

import java.util.List;

import entity.Company;
import entity.Indexes;
import pojo.AreatoCompany;
import pojo.IndexPojo;

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
		 * 查询所有公司 与标签数量
		 * @return
		 * 2018.4.1
		 * @author ss
		 */
		List<Company> getAllCompany();
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
	    /**
	     * 按地区查询公司
	     * @author Asuna
	     * @date 2018/3/30
	     */
	    List<Company> getCompanyByArea();
	    /**
	     * 查询公司详情
	     * @author Asuna
	     * @date 2018/3/30
	     */
	    Company getCompanyDetil(Integer id);
	    /**
	     * 查询公司标签
	     * @author Asuna
	     * @date 2018/3/30
	     */
	    List<IndexPojo> getCompanyIndexes(Integer id);
}
