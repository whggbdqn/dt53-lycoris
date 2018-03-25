package service.impl;

import java.util.List;

import org.jboss.weld.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestExecutionListeners;

import dao.IndexesMapper;
import entity.Indexes;
import service.IndexesService;
@Service("indexesService")
public class indexesServiceImpl implements IndexesService {
@Autowired
private IndexesMapper indexesMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Indexes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Indexes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Indexes selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Indexes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Indexes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Indexes> getFirstClassIndex() {
		return indexesMapper.getFirstClassIndex();
	}

	@Override
	public List<Indexes> getSecondClassIndex() {
		return indexesMapper.getSecondClassIndex();
	}
	
}
