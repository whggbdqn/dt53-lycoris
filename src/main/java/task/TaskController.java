package task;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import entity.Company;
import pojo.AreatoCompany;
import pojo.Background;
import pojo.Skill;
import service.AreaService;
import service.CompanyService;
import service.DataProcessingService;



@Component
public class TaskController {
		@Autowired
		private CompanyService companyService;
		@Autowired
		private AreaService areaService;
		@Autowired
		private DataProcessingService dataProcessingService;
		
	 @Scheduled(fixedRate=1000*60*60*12)
	    public void work8(){
			System.out.println("启动");
			System.out.println("开始数据处理,每12小时执行一次");
			int count=dataProcessingService.DataGo();
			System.out.println("处理结束:共"+count+"条记录被处理!");
			Map<String, Object> map=new HashMap<String, Object>();
				List<Company> company=companyService.getCompanyByArea();
		     	List<AreatoCompany> atc = companyService.getAllAreabyCompany();
		     	List<Background> background=areaService.countAreaBackground();
		     	List<Skill> skill=areaService.countAreaSkill();
		     	int count1=areaService.getCountOrignalData();
		     	int count2=areaService.getCompanyCount();
		     	map.put("atc", atc);
		     	map.put("skill", skill);
		     	map.put("background", background);
		     	map.put("count1", count1);
		    	map.put("count2", count2);
				Gson gson=new Gson();
				try {
					String a=this.getClass().getResource("").getPath();
					a=a.substring(1);
					 String after1="dt53-lycoris\\json\\homepage.json";
					 String after2="dt53-lycoris\\json\\goCompany.json";
					 String ss[]=a.split("dt53-lycoris");
					 String p1=ss[0]+after1;
					 String p2=ss[0]+after2;
					File file1=new File(p1);
					File file2=new File(p2);
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file1), "utf-8"));  
					String s=gson.toJson(map);
					String s1=gson.toJson(company);
					writer.write(s);  
					writer.flush();
					writer=null;
					writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file2), "utf-8"));  
					writer.write(s1);
					 System.out.println("写入成功");
					writer.flush();
					writer.close(); 
				
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
}
