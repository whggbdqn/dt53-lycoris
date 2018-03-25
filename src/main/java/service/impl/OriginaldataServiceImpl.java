package service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OriginaldataMapper;
import entity.Originaldata;
import service.OriginaldataService;

@Service("originaldataService")
public class OriginaldataServiceImpl implements OriginaldataService {
	@Autowired
	private OriginaldataMapper originaldataMapper;
	@Override
	public int insertOrginalData(List<Originaldata> list) {
		int count=0;
		for (Originaldata originaldata : list) {
			//调用数据加入数据库的方法	Tag：Spring接管流程，无法手动new创建对象
			this.insertSelective(originaldata);
			count++;
		}
		
		//删除重复记录
		//delete YourTable where [id] not in ( select max([id]) from YourTable group by (name + value)) 
		return count;
	}

	@Override
	public List<Originaldata> DecodingXlsx() {
		  /**
	     * 读取出filePath中的所有数据信息
	     * @param filePath excel文件的绝对路径
	     * 
	     */
	    String filePath="C:\\Users\\Index\\Documents\\Tencent Files\\1225037533\\FileRecv\\工作簿fan.xlsx";
	        FileInputStream fis =null;
	        Workbook wookbook = null;
	        List<Originaldata>list=new ArrayList<Originaldata>();
	        try
	        {
	            //获取一个绝对地址的流
	              fis = new FileInputStream(filePath);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	       
	        try 
	        {
	            //2003版本的excel，用.xls结尾
	            wookbook = new HSSFWorkbook(fis);//得到工作簿
	        } 
	        catch (Exception ex) 
	        {
	            //ex.printStackTrace();
	            try
	            {
	            	  fis = new FileInputStream(filePath);
	                //2007版本的excel，用.xlsx结尾
	                wookbook = new XSSFWorkbook(fis);//得到工作簿
	            } catch (IOException e)
	            {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        
	        //得到一个工作表
	        Sheet sheet = wookbook.getSheetAt(0);
	        
	        //获得表头
	        Row rowHead = sheet.getRow(0);
	        
	        //判断表头是否正确
	        if(rowHead.getPhysicalNumberOfCells() != 5)
	        {
	            System.out.println("表头的数量不对!");
	        }
	        
	        //获得数据的总行数
	        int totalRowNum = sheet.getLastRowNum();
	        
	        //要获得属性
	        String companyname = "";
	        String areainfo = "";
	        String companyemail = "";
	        String otherinfo = "";
	        String companyinfo = "";
	        
	       //获得所有数据
	        for(int i = 1 ; i <= totalRowNum ; i++)
	        {
	            //获得第i行对象
	            Row row = sheet.getRow(i);
	            Originaldata originaldata=new Originaldata();
	            //获得获得第i行第0列的 String类型对象
	            //名称
	            Cell cell = row.getCell((short)0);
	            companyname = cell.getStringCellValue().toString();
	            //特点
	            Cell cell1 = row.getCell((short)1);
	            companyinfo = cell1.getStringCellValue().toString();
	            //地区
	            Cell cell2 = row.getCell((short)2);
	            areainfo = cell2.getStringCellValue().toString();
	            //邮箱
	            Cell cell3 = row.getCell((short)3);
	            companyemail = cell3.getStringCellValue().toString();
	            //其他
	            Cell cell4 = row.getCell((short)4);
	            otherinfo = cell4.getStringCellValue().toString();
	            originaldata.setCompanyname(companyname);
	            originaldata.setAreainfo(areainfo);
	            originaldata.setCompanyemail(companyemail);
	            originaldata.setOtherinfo(otherinfo);
	            originaldata.setCompanyinfo(companyinfo);
	            list.add(originaldata);
	           // 获得一个数字类型的数据
	           // cell = row.getCell((short)1);
	           // latitude = (int) cell.getNumericCellValue();
	           // System.out.println("公司："+company+"\t"+"特点："+tags);
	        }
		return list;
	}
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Originaldata record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Originaldata record) {
		return originaldataMapper.insertSelective(record);
	}

	@Override
	public Originaldata selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Originaldata record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Originaldata record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Originaldata record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Originaldata> getDataForProcessing() {
		// TODO Auto-generated method stub
		return originaldataMapper.getDataForProcessing();
	}

}
