package service;

import java.util.List;

import entity.Area;
import pojo.Background;
import pojo.Skill;

public interface AreaService {
	  int deleteByPrimaryKey(Integer id);
	    int insert(Area record);
	    int insertSelective(Area record);
	    Area selectByPrimaryKey(Integer id);
	    int updateByPrimaryKeySelective(Area record);
	    int updateByPrimaryKey(Area record);
	    /**
	     * 根据文件查询地区id
	     * @author ss
	     * @date 2018-3-26
	     */
	    int getidArea(String areainfo);
	    /**
	     * 查询地区的技术统计
	     * @author Asuna
	     * @param
	     * @date 2018/3/28
	     */
	    List<Skill> countAreaSkill();
	    /**
	     * 查询地区的面试统计
	     * @author Asuna
	     * @param 
	     * @date 2018/3/28
	     */
	    List<Background> countAreaBackground();
	    /**
	     * 查询所有面试记录
	     * @author Asuna
	     * @date 2018/3/30
	     */
	    int getCountOrignalData();
	    /**
	     * 查询所有公司数量
	     * @author Asuna
	     * @date 2018/3/30
	     */
	    int getCompanyCount();
}
