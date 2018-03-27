package service;

import entity.Area;

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
}
