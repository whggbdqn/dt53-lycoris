package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.DataProcessingService;
import service.TaskService;

@Controller
public class AdminUserController {
	@Autowired
	private DataProcessingService dataProcessingService;
	@Autowired
	private TaskService task;
	@ResponseBody
	@RequestMapping("dataGo.do")
	public int dataGo(){
		System.out.println("开始数据处理");
		int count=dataProcessingService.DataGo();
		task.work8();
		return count;
	}
}
