package service;


import java.util.List;

import entity.User;
public interface UserService {
	 
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
