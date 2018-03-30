package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import entity.Originaldata;
import service.OriginaldataService;
import util.ExcelUtil;

@Controller
public class OriginaldataController {
	@Autowired
	private OriginaldataService originaldataService;
	@RequestMapping("downloadExcel.do")
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

		@RequestMapping("uploadExcel.do")
	  public String upload(HttpServletRequest request,String inputName,@RequestParam(value="pfile") CommonsMultipartFile pfile,Model model){
			try {
				System.out.println("进入功能");
				String path=request.getSession().getServletContext().getRealPath("upload");
				System.out.println(123);
				String uploadFileName=pfile.getOriginalFilename();
				System.out.println(uploadFileName);
				String expname=uploadFileName.substring(uploadFileName.lastIndexOf("."));
				System.out.println(expname);
				String fileName="面试反馈表"+expname;//System.currentTimeMillis()+expname;
				System.out.println(fileName);
				File targetFile=new File(path+"\\"+fileName);	
				System.out.println(targetFile);
				//获取项目中upload文件夹中上传表格的绝对路径
				String Excelpath=request.getSession().getServletContext().getRealPath("upload")+"\\面试反馈表.xlsx";
				System.out.println("最后的地址输出："+Excelpath);
				pfile.transferTo(targetFile);//上传  保存
				System.out.println("上传文件成功！");
				model.addAttribute("info", "上传文件成功！");
				try {
					//调业务读取Excel，获得数据集合list
					List<Originaldata>list =originaldataService.DecodingXlsx(Excelpath);
					//将数据list集合存入数据库
					int count=originaldataService.insertOrginalData(list);
					System.out.println("数据放入数据库成功"+count);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("数据放入数据库失败");
				}
			} catch (Exception e) {
				model.addAttribute("info", "上传文件失败！");
			}
			return "adminUser.jsp";
		}
}
