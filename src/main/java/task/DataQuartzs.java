package task;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import service.WritingJsonTaskinterface;

@Component
public class DataQuartzs {
	 @Autowired
     private WritingJsonTaskinterface wiritingJsonTask;
	 @Autowired
	 private  HttpServletRequest request;
	 /**
     * 主页请求
     * @author ss
    * @return 
     * @date 2018/3/27
     */
	 @Scheduled(fixedRate=1000*5)
    public void showMainPage(){
	  String path =request.getSession().getServletContext().getRealPath("json");
	  System.out.println(path);
   	 this.goJsonFileHomePage(1,path+"//homepage.json");
    }
    /**
     * 测试写入json文件
     * @author Asuna
     * date 2018/3/28
     * @param id
     */
    public void goJsonFileHomePage(int id,String path){
   	 wiritingJsonTask.goJsonFileHomePage(id,path);
    }
}
