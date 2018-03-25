package user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import dao.UserMapper;
import entity.User;
import service.UserService;

public class UserTest {

	@Test
	public void test() {
		ApplicationContext cex=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper=(UserMapper)cex.getBean("userMapper");
		User user=new User();
		user.setPassword("1111");
		user.setUserid("yangfan");
		user.setUsername("杨番");  
		user.setIdgrade(2);
		user.setId(4);
		System.out.println(userMapper.insertSelective(user));
	}
	@Test
	public void test1() {
		ApplicationContext cex=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService)cex.getBean("userService");
		User user=new User();
		user.setPassword("2222");
		user.setUserid("ywz");
		user.setUsername("杨文章");  
		user.setIdgrade(2);
		user.setId(5);
		System.out.println(userService.insertSelective(user));
	}
	
	@Test
	public void test2() {
		ApplicationContext cex=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService)cex.getBean("userService");
		System.out.println(userService.getAllUserPartInfo().size());
	}

}
