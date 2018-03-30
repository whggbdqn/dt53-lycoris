package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dao.AreaMapper;
import dao.UserMapper;
import entity.Area;
import pojo.Background;
import pojo.Skill;
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
	  /**
     * 查询地区的技术统计
     * @author Asuna
     * @param 地区表主键
     * @date 2018/3/28
     */
	@Override
	public List<Skill> countAreaSkill() {
		return areaMapper.countAreaSkill();
	}
	/**
     * 查询地区的面试统计
     * @author Asuna
     * @param 地区表主键
     * @date 2018/3/28
     */
	@Override
	public List<Background> countAreaBackground() {
		return areaMapper.countAreaBackground();
	}

	@Override
	public int getCountOrignalData() {
		return areaMapper.getCountOrignalData();
	}
	/**
     * 查询所有公司数量
     * @author Asuna
     * @date 2018/3/30
     */
	@Override
	public int getCompanyCount() {
		return areaMapper.getCompanyCount();
	}
}
