package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CompanytoindexMapper;
import entity.Companytoindex;
import service.CompanytoindexService;
@Service("companytoindexService")
public class CompanytoindexServiceImpl implements CompanytoindexService {
@Autowired
private CompanytoindexMapper companytoindexMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Companytoindex record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional
	@Override//测试成功 by ss
	public int insertSelective(Companytoindex record) {
		return companytoindexMapper.insertSelective(record);
	}

	@Override
	public Companytoindex selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Companytoindex record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Companytoindex record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
