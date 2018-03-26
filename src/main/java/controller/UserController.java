package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.User;
import service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查询所有用户  分页 条件查询？？？
	 * @param rows	页大小 
	 * @param page	页码
	 * @return	用户分页map集合
	 * @throws Exception
	 */
	@ResponseBody 
	@RequestMapping("/getAllUser.do")
	public Map<String, Object> getAllUsers(Model model,Integer rows,Integer page)throws Exception{
		 rows=1;
		 page=1;
		PageHelper.startPage(page,rows);
		System.out.println("页大小:"+rows);
		System.out.println("页码:"+page);
		//查询所有学生信息
		PageHelper.startPage(page,rows);
		List<User> Infolist= userService.getAllUser();
		System.out.println(Infolist.size());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("rows", Infolist);
		map.put("total",new PageInfo<User>(Infolist).getTotal());
		model.addAttribute("map",map);
	    return map;
	}
	//主键查询用户资料
	@RequestMapping("user.do")
				public String show(Model model) throws Exception{	
		            int id=1;
					User user=userService.getUserMessage(id);
					model.addAttribute("user", user);
					return "index.jsp";
		}
	//主键修改用户资料
	@RequestMapping("updateuser.do")
				public String updateusermessage(Model model) throws Exception{
		
					int id=1;
					User record=userService.getUserMessage(id);
					record.setUsername("ywz");		    
				    
					int count=userService.updateByPrimaryKeySelective(record);
					model.addAttribute("count", count);
					return "index.jsp";
		}

	/**
	 * 头像上传回显
	 * @param users	用户实体只取 图片
	 * @param uploadFile 需要上传的文件
	 * @param request	请求
	 * @param model	返回model
	 * @return	网页路径
	 */
	@RequestMapping("file.do")
	public String file(User users,@RequestParam(value="file",required=false)MultipartFile uploadFile,HttpServletRequest request,ModelMap model) {
			  System.out.println("上传uploadFile件"+uploadFile.toString());
			  String imageName = String.valueOf(new Date().getTime());
			  System.out.println(imageName);
				  String path = request.getSession().getServletContext().getRealPath("/")+"image/"+imageName;
				  String path1 = request.getContextPath()+"/image/"+imageName;
				  int id=1;
				  User record=userService.getUserMessage(id);
				  record.setPicture(path1);
				  int count=userService.updateByPrimaryKeySelective(record);
				  System.out.println("count:"+count);
				  System.out.println(request.getContextPath());
			  File file = new File(path);
			  try {
				  uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  model.addAttribute("image", path1);
			  return "index.jsp";
	}

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
	

