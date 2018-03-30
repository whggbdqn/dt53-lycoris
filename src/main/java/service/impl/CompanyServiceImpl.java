package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CompanyMapper;
import entity.Company;
import entity.Indexes;
import pojo.AreatoCompany;
import pojo.IndexPojo;
import service.CompanyService;
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
@Autowired
private CompanyMapper companyMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override
	public int insertSelective(Company record) {
		return companyMapper.insertSelective(record);
	}

	@Override
	public Company selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(Company record) {
		return companyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkCompanyName(String companyName) {
		companyName="%"+companyName+"%";
		return companyMapper.checkCompanyName(companyName);
	}
	@Override
	public List<AreatoCompany> getAllAreabyCompany() {
		return companyMapper.getAllAreabyCompany();
	}

	@Override
	public void setTime(String time) {
		companyMapper.setTime(time);
	}
	 /**
     * 按地区查询公司
     * @author Asuna
     * @date 2018/3/30
     */
	@Override//测试成功 By ss
	public List<Company> getCompanyByArea() {
		return companyMapper.getCompanyByArea();
	}
	 /**
     * 查询公司详情
     * @author Asuna
     * @date 2018/3/30
     */
	@Override
	public Company getCompanyDetil(Integer id) {
		return companyMapper.getCompanyDetil(id);
	}

	 /**
     * 查询公司标签
     * @author Asuna
     * @date 2018/3/30
     */
	public List<IndexPojo> getCompanyIndexes(Integer id){
		return companyMapper.getCompanyIndexes(id);
	}
	
}
