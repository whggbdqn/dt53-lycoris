package service;

import java.util.List;

import entity.User;
import entity.Usertocompany;

public interface UserService {
	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	List<User> getAllUser();
	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return  影响行数
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 收藏公司
	 * @param userId	用户id
	 * @param companyId	公司ID
	 * @return	影响行数
	 */
	int keepCompany(Integer userId,Integer companyId);
	
	/**
	 * 取消收藏公司
	 * @param id	单条记录iD
	 * @return	影响行数 
	 */
	int cancleKeepCompany(Integer id);

	/**
	 * 查询个人已收藏的公司及信息
	 * @param 主键
	 * @return	公司集合
	 */
	List<Usertocompany> getAllCompanyByUser(Integer id);
	int insert(User record);

	/**
	 * 根据主键id查询单条用户信息
	 * @param id 主键
	 * @return	用户实体
	 */
	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	User getUserMessage(int id);
	 
		/**
		 *  注册用户
		 * @param   传用户实体
		 * @return  返回影响行数
		 * @author  yf
		 */
		int insertSelective(User user);
		
		/**
		 *  登录
		 * @param   传用户实体
		 * @return  返回实体集合
		 * @author  yf
		 */
	    List<User> getAllUserPartInfo();	
}
	