package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CompanyMapper;
import entity.Company;
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

}
