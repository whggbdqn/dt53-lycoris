package dao;

import java.util.List;

import entity.User;
import entity.Usertocompany;

public interface UserMapper {
	/**
	 * 通过用户主键查询用户信息
	 * @param id
	 * @return
	 * @author ywz  2018.3.25  14:50
	 */
	User getUserMessage(int id);
	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	List<User> getAllUser();
	
	/**
	 * 查询个人已收藏的公司及信息
	 * @return	
	 */
	List<Usertocompany> getAllCompanyByUser(Integer id);
	/**
	 * 多选删除用户
	 * @param user_value
	 * @return
	 * @author ywz  2018.3.28  10：00
	 */
    int delmanyukey(Integer[] user_value);
    /**
	 * 单条删除用户
	 * @param id
	 * @return
	 * @author ywz  2018.3.28  10：00
	 */
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    int insertSelective(User record);//注册
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    //查询登录
    List<User> getAllUserPartInfo();
    /**
     * 登录
     * @author ss
     * @date 2018/3/27
     * 
     */
    User loginDo(User user);
    
}