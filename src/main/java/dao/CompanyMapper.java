package dao;

import java.util.List;

import entity.Company;
import entity.Indexes;
import pojo.AreatoCompany;
import pojo.CompanyInfoLabel;
import pojo.IndexPojo;

public interface CompanyMapper {
    //对应删除公司下的标签表的内容
    int delCompanytoIndexes(int idcompany);
	/**
	 * 查询所有公司 与标签数量
	 * @return
	 * 2018.4.1
	 * @author ss
	 */
	List<Company> getAllCompany();
	/**
	 * 通过主键删除公司
	 * @param id
	 * @return
	 * @author ywz
	 */
    int deleteByPrimaryKey(Integer id);
    /**
	 * id多选删除
	 * @param List<company>
	 * @return
	 * @author ywz
	 */
    int delmanyckey(Integer[] chk_value);
    /**
     * 添加公司
     * @param record
     * @return
     * @author ywz
     */
    int insertSelective(Company record);
    /**
     * 修改公司信息
     * @param record
     * @return
     * @author ywz
     */
    int updateByPrimaryKeySelective(Company record);
    /**
     * 通过模糊查询公司名找公司
     * @param company
     * @return
     */
    List<Company> getnamecompany(String companyname);
    
    int insert(Company record);   
    /**
     * 根据ID 查询公司
     * @param id 主键
     * @return
     */
    Company selectByPrimaryKey(Integer id); 
    int updateByPrimaryKeyWithBLOBs(Company record);
    int updateByPrimaryKey(Company record);
    /**
     * 查询公司技术标签（公司详情图表专用）
     * @return
     */
    List<CompanyInfoLabel> getLabelByTechnology(Integer id);
    /**
     * 查询公司面试（人事）标签（公司详情图表专用）
     * @return
     */
    List<CompanyInfoLabel> getLabelByPersonnel(Integer id);
    /**
     * 根据ID查询公司所有标签
     * @return
     */
    List<CompanyInfoLabel> getLabelByCompany(Integer id);
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