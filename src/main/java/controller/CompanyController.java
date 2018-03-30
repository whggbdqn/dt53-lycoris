package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.Company;
import service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("goCompany.do")
	public String getCompanyByArea(Integer num,Model model){
		//if(num==null || num==0) num=1;  //当第一次访问，没有传递页码时默认第一页
		//分页
		//设置分页   	PageHelper.startPage(页码, 页大小);
	//	PageHelper.startPage(num, 15);
		 //调用业务
		List<Company> list=companyService.getCompanyByArea();
		//获取分页相关的信息
	//	PageInfo pageInfo=new PageInfo(list);
		//System.out.println("页码:"+pageInfo.getPageNum());
		//System.out.println("总页数:"+pageInfo.getPages());
		//System.out.println("页大小:"+pageInfo.getPageSize());
		//System.out.println("总记录数:"+pageInfo.getTotal());
		model.addAttribute("list",list);  //将数据设置model对象中，传递给页面
		//model.addAttribute("pageInfo",pageInfo);  //分页相关的实体信息
		System.out.println(1);
		return "goCompany.jsp";  //返回视图
	}
}
