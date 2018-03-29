package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import service.WritingJsonTaskinterface;

@Component
@EnableScheduling
public class DataQuartzs {
	 @Autowired
     private WritingJsonTaskinterface wiritingJsonTask;
	 /**
     * 主页请求
     * @author ss
    * @return 
     * @date 2018/3/27
     */
    @Scheduled(cron = "0/5 * * * * ?")//每隔5秒执行一次
    public void showMainPage(HttpServletRequest request){
 	String path =request.getSession().getServletContext().getRealPath("json");
   	 this.goJsonFileHomePage(1,path+"//homepage.json");
   	 System.out.println(1);
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
