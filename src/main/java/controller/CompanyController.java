package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Company;
import pojo.IndexPojo;
import service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	private Integer ids[];
			//多项公司删除 业务逻辑问题//废弃
			/*@RequestMapping("delCompanyIndexes.do")
			public int delCompanyIndexes(){
				int count=companyService.delmanyckey(ids);
				return count;
			}*/
		//删除公司及公司对应的标签
			@RequestMapping("CompanyAndIndexes.do")
			public ModelAndView delCompanyAndIndexes(Integer id){
				companyService.delCompanyAndIndexes(id);
				return new ModelAndView("getCompanyForM.do");
			}
	@RequestMapping("goCompany.do")
	public String getCompanyByArea(Integer num,Model model){
		List<Company> list=companyService.getCompanyByArea();
		model.addAttribute("list",list);  //将数据设置model对象中，传递给页面
		return "goCompany.jsp";  //返回视图
	}
	
	@RequestMapping("CompanyDetil.do")
	public String getCompanyDetil(Integer id,Model model){
		Company company=companyService.getCompanyDetil(id);
		model.addAttribute("company",company);  //将数据设置model对象中，传递给页面
		return "CompanyDetil.jsp";  //返回视图
	}
	@ResponseBody
	@RequestMapping("CompanyIndexes.do")
	public List<IndexPojo> getCompanyIndexes(Integer id,Model model){
		List<IndexPojo> list=companyService.getCompanyIndexes(id);
		return list;
	}
	@RequestMapping("getCompanyForM.do")
	public String getCompanyForM(Model model){
		List<Company> list= companyService.getAllCompany();
		model.addAttribute("list",list);  //将数据设置model对象中，传递给页面
		return "CompanyManage.jsp";
	}
}
