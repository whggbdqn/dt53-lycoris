package service.impl;

import service.CompanyService;
import service.DataProcessingService;
import service.IndexCheck;
import service.OriginaldataService;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import entity.Originaldata;
@Component("dataProcessingService")
public class DataProcessingServiceImpl implements DataProcessingService {
	@Autowired
	private OriginaldataService originaldataService;//原始数据
	@Autowired
	private IndexCheck indexCheck;
	@Autowired
	private CompanyService companyService;
	//第一次处理结果集
	private HashMap<String, Object> resultInfo;
	//用于把处理后的结果集修改成要入库的字段
	private StringBuffer cominfo;
		/**
		 * 数据处理
		 * @author ss
		 * @date 2018-3-25
		 * 
		 */
		 @SuppressWarnings("unchecked")
		public int DataGo(){
			 int count=0;//初始化计数器
			 List<Originaldata> originaldata = originaldataService.getDataForProcessing();//获取数据列表
			 Set<String> FirstProcessing=null;
			 Set<String> SecondProcessing=null;
			 String resultString;
			 for (Originaldata od : originaldata) {//开始第一次每条处理
				 resultInfo=this.FirstGo(od.getCompanyinfo().toLowerCase());
				FirstProcessing= (Set<String>) resultInfo.get("sensitiveWordList");
				 //第一次处理返回被处理后文本
				resultString= (String) resultInfo.get("companyinfo") ;
				//清空map集合
				resultInfo=null;
				//第二次处理获取关键字集合
				SecondProcessing=this.SecondGo(resultString);
				//resultString=(String) resultInfo.get("companyinfo");
				FirstProcessing.addAll(SecondProcessing);
				//开始插入业务
					//寻找对应公司
				count=companyService.checkCompanyName(od.getCompanyname());
				if(count==1){
					
				}
			}
			 return count;
		 };
		 private String getCompanyInfo(Set<String> set){
			 	for (String str : set) {
					cominfo.append(str).append("，");
				}
			return cominfo.deleteCharAt(cominfo.length()-1).toString();
		 };
		 
		/**
		  * 第一次过滤,返回一级关键词集合
		  * @author ss
		  * @date 2018-3-25
		  */
		@Override
		public HashMap<String, Object> FirstGo(String companyinfo) {
			return (HashMap<String, Object>) indexCheck.replaceSensitiveWord(companyinfo, 1,"",1);
		}
		@Override
		public Set<String> SecondGo(String companyinfo) {
			return indexCheck.getSensitiveWord(companyinfo, 1, 2);
		}
		
		public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			DataProcessingService dps=(DataProcessingService)ctx.getBean("dataProcessingService");
			dps.DataGo();
		}
	}
