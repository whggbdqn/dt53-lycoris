package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Company;
import pojo.IndexPojo;
import service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	//多项公司删除
			@RequestMapping("delCompanyIndexes.do")
			public void delCompanyIndexes(Integer id,Model model){
				Integer chk_value[]={4,5,6};
				int count=companyService.delmanyckey(chk_value);
				System.out.println(count);
			}
			
		//删除公司及公司对应的标签
			@ResponseBody
			@RequestMapping("CompanyAndIndexes.do")
			public int delCompanyAndIndexes(Integer idcompany,Model model){
				idcompany=7;
				int count=companyService.delCompanyAndIndexes(idcompany);
				System.out.println(count);
				return count;
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
		for (Company company : list) {
			System.out.println(company.getId()+"-----"+company.getCompanyname()+"-----------"+company.getIndexcount());
		}
		model.addAttribute("list",list);  //将数据设置model对象中，传递给页面
		return "CompanyManage.jsp";
	}
}
