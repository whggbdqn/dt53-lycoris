package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller
public class UserController {
     @Autowired
     private UserService userService;
     
     //登录
     @RequestMapping("/Login.do")
     public String LoginUser(User user) throws Exception{
    	user.setPassword("123456");
    	user.setUserid("5100");
    	List<User> list=userService.getAllUserPartInfo();
    	   for (User u : list) {
				if(u.getUserid()==user.getUserid()){
					if(u.getPassword()==user.getPassword()){
						return "index.jsp";
					}else{
						System.out.println("用户密码错误");
					}
				}else{
					if(u.getPassword()==user.getPassword()){
						System.out.println("用户ID错误");
					}else{
						System.out.println("用户ID错误，密码错误");
					}
				}
			} 
    	     return "index.jsp";
     }
     
     //注册
     @RequestMapping("/Register.do")
     public String registerUser(User user) throws Exception{
    	 List<User> list=userService.getAllUserPartInfo();
    	 for (User u : list) {
    		 if(user.getUserid()==u.getUserid()){
    			 System.out.println("用户ID已存在");
    		 }
		}   	
    	int count=userService.insertSelective(user);
    	return "Login.jsp";
     }
}
