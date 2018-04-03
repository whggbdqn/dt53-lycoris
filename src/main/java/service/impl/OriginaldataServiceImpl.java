package service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
	public List<Originaldata> DecodingXlsx(String Excelpath) {
		  /**
	     * 读取出filePath中的所有数据信息
	     * @param filePath excel文件的绝对路径
	     * 
	     */
	    String filePath=Excelpath;
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
	        if(rowHead.getPhysicalNumberOfCells() != 4)
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
	        for(int i = 2 ; i <= totalRowNum ; i++)
	        {
	            //获得第i行对象
	            Row row = sheet.getRow(i);
	            Originaldata originaldata=new Originaldata();
	            //获得获得第i行第0列的 String类型对象
	            //名称
	            Cell cell = row.getCell((short)0);
	            companyname = cell.getStringCellValue().toString().trim();
	            //特点
	            Cell cell1 = row.getCell((short)1);
	            cell1.setCellType(CellType.STRING);
	            companyinfo= cell1.getStringCellValue().toString().trim();
	            //地区
	            Cell cell2 = row.getCell((short)2);
	            areainfo = cell2.getStringCellValue().toString().trim();
	            //邮箱
	            Cell cell3 = row.getCell((short)3);
	            if(null==cell3||null==cell3.getStringCellValue()){
	            	companyemail=null;
	            }else{
	            	companyemail = cell3.getStringCellValue().toString().trim();
	            }
	            //其他
	           // Cell cell4 = row.getCell((short)4);
	            otherinfo = "0";//cell4.getStringCellValue().toString();
	            originaldata.setCompanyname(companyname);
	            originaldata.setAreainfo(areainfo);
	            originaldata.setCompanyemail(companyemail);
	            originaldata.setOtherinfo(otherinfo);
	            originaldata.setCompanyinfo(companyinfo);
	            list.add(originaldata);
	           // 获得一个数字类型的数据
	           // cell = row.getCell((short)1);
	           // latitude = (int) cell.getNumericCellValue();
	          // System.out.println("公司："+originaldata.getCompanyname()+"\t"+"地区："+originaldata.getAreainfo()+"\t"+"特点："+originaldata.getCompanyinfo()+"\t"+"邮箱："+originaldata.getCompanyemail());
	            
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
		return originaldataMapper.updateFlag();
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
	public void updateAfterProcessing() {
		originaldataMapper.updateAfterProcessing();
	}
	@Override
	public List<Originaldata> getDataForProcessing() {
		// TODO Auto-generated method stub
		return originaldataMapper.getDataForProcessing();
	}
/*public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	OriginaldataService dps=(OriginaldataService)ctx.getBean("originaldataService");
	dps.insertOrginalData(dps.DecodingXlsx());
}*/
	@Override
	public int updateFlag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upExcelFile() {
		// TODO Auto-generated method stub
		return 0;
	}
}
