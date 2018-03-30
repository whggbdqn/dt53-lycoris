package controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ExcelUtil;

@Controller
public class OriginaldataController {
	
	@RequestMapping("/downloadExcel.do")
	public String doGet(HttpServletRequest request, HttpServletResponse response,ServletOutputStream outputStream) throws Exception {
		  //处理下载文件乱码问题
        response.setContentType("application/x-execl");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("面试反馈表.xlsx".getBytes(), "ISO-8859-1"));
        outputStream = response.getOutputStream();
        try {
            ExcelUtil.exportExcel(outputStream);  //封装的工具类
            System.out.println("文件下载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(outputStream!=null){
            outputStream.close();
        }
        return null;
	}
}
