package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMapper;
import dao.UsertocompanyMapper;
import entity.User;
import entity.Usertocompany;
import service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UsertocompanyMapper usertocompanyMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getAllUser();
	}
	
	/**
	 * 收藏公司
	 * @param 用户ID 公司ID
	 */
	@Override
	public int keepCompany(Integer userId, Integer companyId) {
		Usertocompany uc=new Usertocompany();
		uc.setIduser(userId);
		uc.setIdcompany(companyId);
		// TODO Auto-generated method stub
		return usertocompanyMapper.insert(uc);
	}
	
	/**
	 * 取消收藏
	 * @param 主键
	 */
	@Override
	public int cancleKeepCompany(Integer id) {
		// TODO Auto-generated method stub
		return usertocompanyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Usertocompany> getAllCompanyByUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getAllCompanyByUser(id);
	}
	@Override
	public User getUserMessage(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserMessage(id);
	}
	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}
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