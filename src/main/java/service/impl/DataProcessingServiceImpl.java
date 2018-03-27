package service.impl;

import service.AreaService;
import service.CompanyService;
import service.CompanytoindexService;
import service.DataProcessingService;
import service.IndexCheck;
import service.IndexesService;
import service.OriginaldataService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import entity.Area;
import entity.Company;
import entity.Companytoindex;
import entity.Originaldata;
@Component("dataProcessingService")
public class DataProcessingServiceImpl implements DataProcessingService {
	@Autowired
	private OriginaldataService originaldataService;//原始数据
	@Autowired
	private IndexCheck indexCheck;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private IndexesService indexesService;
	@Autowired
	private CompanytoindexService companytoindexService;
	@Autowired
	private AreaService areaService;
	//第一次处理结果集
	private HashMap<String, Object> resultInfo;
	private Companytoindex record;
	private Company company;
	private Area area ;
		/**
		 * 数据处理
		 * @author ss
		 * @date 2018/3/25-3/27
		 * 
		 */
		 @SuppressWarnings("unchecked")
		public int DataGo(){
			 int count=0;//初始化计数器
			 List<Originaldata> originaldata = originaldataService.getDataForProcessing();//获取数据列表
			 Set<String> FirstProcessing=null;
			 Set<String> SecondProcessing=null;
			 String resultString;
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String time=df.format(new Date());//记录当前时间
			 for (Originaldata od : originaldata) {//开始每条处理
				 company=new Company();
				 company.setCompanyemail(od.getCompanyemail());
				 resultInfo=this.FirstGo(od.getCompanyinfo().toLowerCase());
				FirstProcessing= (Set<String>) resultInfo.get("sensitiveWordList");
				 //第一次处理返回被处理后文本
				resultString= (String) resultInfo.get("companyinfo") ;
				//清空map集合
				resultInfo=null;
				//第二次处理获取关键字集合
				SecondProcessing=this.SecondGo(resultString);
				//resultString=(String) resultInfo.get("companyinfo");废弃业务,返回除去关键字剩余的原文本,预计用于更新索引库
				FirstProcessing.addAll(SecondProcessing);
				//开始插入业务
				int idcompany=0;//寻找对应公司
				idcompany=companyService.checkCompanyName(od.getCompanyname());
				//如果查到有记录
				if(idcompany>0){
					int id=0;
					for (String index : FirstProcessing) {
						//查出索引词对应的id
						id=indexesService.getIndexID(index);
						//插入索引公司对照表
						record=new Companytoindex();
						record.setIdcompany(idcompany);
						record.setIdindexes(id);
						companytoindexService.insertSelective(record);
						company.setId(idcompany);
						//companyService.updateByPrimaryKeySelective(company);//记录时间
						count++;
					}
				}else{//没有该公司记录插入新的公司记录
						company.setCompanyname(od.getCompanyname());//设置实体属性--名称
						//获取公司地址
						int idarea=0;
						idarea=areaService.getidArea(od.getAreainfo());
					if(idarea>0){
						company.setIdarea(idarea);//设置实体属性--地区
						}else{
							area.setAreainfo(od.getAreainfo());
							areaService.insertSelective(area);
							idarea=areaService.getidArea(od.getAreainfo());
							company.setIdarea(idarea);//设置实体属性--地区
						}
						companyService.insertSelective(company);//插入,包含时间
						idcompany=companyService.checkCompanyName(od.getCompanyname());
						//插入索引公司对照表
						int id=0;
						for (String index : FirstProcessing) {
							//查出索引词对应的id
							record=new Companytoindex();
							id=indexesService.getIndexID(index);
							//插入索引公司对照表
							record.setIdcompany(idcompany);
							record.setIdindexes(id);
							companytoindexService.insertSelective(record);
							count++;
						}
				}
			}
			 originaldataService.updateAfterProcessing();//修改原始数据标识,表示已处理
			 companyService.setTime(time);
			 return count;
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
		/**
		  * 第二次过滤,返回二级关键词集合
		  * @author ss
		  * @date 2018-3-25
		  */
		@Override
		public Set<String> SecondGo(String companyinfo) {
			return indexCheck.getSensitiveWord(companyinfo, 1, 2);
		}
		//测试成功 by ss 有点小问题,部分公司没有更新时间
		public static void main(String[] args) {
			ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			DataProcessingService dps=(DataProcessingService)ctx.getBean("dataProcessingService");
			dps.DataGo();
		}
	}
