package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Indexes;
import service.IndexesService;

@Controller
public class IndexesController {
	@Autowired
	private IndexesService indexesService;
	
	@RequestMapping("index.s")
	public String insertSelective(Indexes indexes,HttpSession session) throws Exception {
		int temp=indexesService.insertSelective(indexes);
		if(temp == 1){
			
		}
		return "index.jsp";
	}
}
