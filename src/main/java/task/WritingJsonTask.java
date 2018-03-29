package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pojo.AreatoCompany;
import pojo.Background;
import pojo.Skill;
import service.AreaService;
import service.CompanyService;
import service.WritingJsonTaskinterface;

@Component("wiritingJsonTask")
public class WritingJsonTask implements WritingJsonTaskinterface {
@Autowired
private AreaService areaService;
@Autowired
private CompanyService companyService;
	/**
	 * 将查出的数据库数据写成json文件/首页
	 * @author Asuna
	 * @date 2018/3/28
	 * 
	 */
	public void goJsonFileHomePage(int id,String path){
		 Map<String, Object> map=new HashMap<String, Object>();
    	List<AreatoCompany> atc = companyService.getAllAreabyCompany();
    	List<Background> background=areaService.countAreaBackground(id);
    	List<Skill> skill=areaService.countAreaSkill(id);
    	map.put("atc", atc);
    	map.put("skill", skill);
    	map.put("background", background);
		Gson gson=new Gson();
		try {
			writeFile(path, gson.toJson(map),"utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static void writeFile(String filePath, String sets,String encoding)  
	            throws IOException {  
	       	File file=new File(filePath); 
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file), encoding));  
	        writer.write(sets);  
	        writer.close(); 
	    }  
}
