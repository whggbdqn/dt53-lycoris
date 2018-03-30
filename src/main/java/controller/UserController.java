package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.AreatoCompany;
import pojo.Background;
import pojo.Skill;
import service.AreaService;
import service.CompanyService;

@Controller
@EnableScheduling 
public class UserController {
     @Autowired
     private AreaService areaService;
     @Autowired
     private CompanyService companyService;
     @Autowired
     /**
      * 新UI界面测试
      * @author Asuna
      * @date 2018/3/29
      */
     @ResponseBody
     @RequestMapping("homepage.do")
     public Map<String,Object> getHomePageData(){
    	 int id=1;
    	 Map<String, Object> map=new HashMap<String, Object>();
     	List<AreatoCompany> atc = companyService.getAllAreabyCompany();
     	List<Background> background=areaService.countAreaBackground(id);
     	List<Skill> skill=areaService.countAreaSkill(id);
     	map.put("atc", atc);
     	map.put("skill", skill);
     	map.put("background", background);
		return map;
     }
}
