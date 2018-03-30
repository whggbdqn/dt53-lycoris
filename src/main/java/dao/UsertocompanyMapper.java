package dao;

import entity.Usertocompany;

public interface UsertocompanyMapper {

	/**
	 * 收藏公司
	 * @param uc 多对多实体
	 * @return	影响行数
	 */
	int	keepCompany(Usertocompany uc);
	/**
	 * 取消收藏公司
	 * @param id	单条记录iD
	 * @return	影响行数 
	 */
	int cancleKeepCompany(Integer id);
    int deleteByPrimaryKey(Integer id);
    int insert(Usertocompany record);
    int insertSelective(Usertocompany record);
    Usertocompany selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Usertocompany record);
    int updateByPrimaryKey(Usertocompany record);
}