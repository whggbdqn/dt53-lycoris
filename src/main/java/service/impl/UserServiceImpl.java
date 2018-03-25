package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMapper;
import entity.User;
import service.UserService;
@Service("userService") 
public class UserServiceImpl implements UserService {
       
	@Autowired
	private UserMapper userMapper;

	/**
	 *  注册用户
	 * @param   传用户实体
	 * @return  返回影响行数
	 * @author  yf 3.25日11点
	 */
	public int insertSelective(User user) {
		
		return userMapper.insertSelective(user);
	}

	/**
	 *  登录
	 * @param   传用户实体
	 * @return  返回实体集合
	 * @author  yf
	 */
	public List<User> getAllUserPartInfo() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserPartInfo();
	}

	
}
