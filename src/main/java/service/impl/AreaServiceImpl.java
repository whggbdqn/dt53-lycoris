package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dao.AreaMapper;
import dao.UserMapper;
import entity.Area;
import service.AreaService;
@Service("areaService")
public class AreaServiceImpl implements AreaService {
@Autowired
private AreaMapper areaMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Area record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Area record) {
		return areaMapper.insertSelective(record);
	}

	@Override
	public Area selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Area record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Area record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override//测试成功 by ss
	public int getidArea(String areainfo) {
		 areainfo="%"+areainfo+"%";
		return areaMapper.getidArea(areainfo);
	}
}
