package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.IndexesMapper;
import entity.Indexes;
import entity.Usertoindex;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("g.do")
     public String showTaglevel(Model model)throws Exception {
    	List<Indexes> list= userService.getUserIndexes();
    	System.out.println(list.size());
    	model.addAttribute("list", list);
    	return "index.jsp";
     }
	
	@RequestMapping("indexes.do")
    public String addindexes(Model model,Usertoindex record)throws Exception {
    record.setIduser(1);
    record.setIdindexes(2);
   	int count= userService.insert(record);
   	System.out.println(count);
   	model.addAttribute("c", count);
   	return "index.jsp";
    }
}
