package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class Excelupload {
	    @RequestMapping("/Excelupload.do")
	    public String upload(HttpServletRequest request,String inputName,@RequestParam(value="pfile") CommonsMultipartFile pfile,Model model){
			try {
				System.out.println("进入功能");
				String path=request.getSession().getServletContext().getRealPath("upload");
				System.out.println(path);
				String uploadFileName=pfile.getOriginalFilename();
				System.out.println(uploadFileName);
				String expname=uploadFileName.substring(uploadFileName.lastIndexOf("."));
				System.out.println(expname);
				String fileName=System.currentTimeMillis()+expname;
				System.out.println(fileName);
				File targetFile=new File(path+"\\"+fileName);	
				System.out.println(targetFile);
				pfile.transferTo(targetFile);//上传  保存
				model.addAttribute("info", "上传文件成功:");
			} catch (Exception e) {
				model.addAttribute("info", "上传文件失败");
			}
			return "MyJsp.jsp";
		}
	  
	    
}
