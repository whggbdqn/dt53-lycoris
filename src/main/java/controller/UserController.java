package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import service.UserService;
import service.WritingJsonTaskinterface;

@Controller
@EnableScheduling 
public class UserController {
     @Autowired
     private UserService userService;
     //登录
     @RequestMapping("/Login.do")
     public String LoginUser(User user,HttpSession session) throws Exception{
    	 user=userService.loginDo(user);
    	 if(user.getId()>0){
    		 session.setAttribute("user", user);
    		 return "homepage.jsp";
    	 }else{
    		 return "homepage.jsp";
    	 }
     }
     //注册
     @ResponseBody
     @RequestMapping("/Register.do")
     public int registerUser(User user,String userid) throws Exception{
    	 List<User> list=userService.getAllUserPartInfo();
    	 String userid1="5100";
    	 int count=-1;
    	 for (User u : list) {
    		 if(userid1==u.getUserid()){
    			return count=0;
    		 }
		}  	
        count=userService.insertSelective(user);
    	return count;
     }
     
}
