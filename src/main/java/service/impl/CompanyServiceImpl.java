package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public int insertSelective(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Company selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Company record) {
		// TODO Auto-generated method stub
		return 0;
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
