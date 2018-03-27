package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import pojo.AreatoCompany;
import service.CompanyService;
import service.UserService;

@Controller
public class UserController {
     @Autowired
     private UserService userService;
     @Autowired
     private CompanyService companyService;
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
     
     /**
      * 主页请求
      * @author ss
      * @date 2018/3/27
      */
     @ResponseBody
     @RequestMapping("homepage.do")
     public List<AreatoCompany> showMainPage(){
    	List<AreatoCompany> atc = companyService.getAllAreabyCompany();
    	
    	return atc;
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
