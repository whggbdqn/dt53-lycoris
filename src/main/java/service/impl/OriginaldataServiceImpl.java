package service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
	    String filePath="D:\\CreateTest2.xlsx";
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
	        for(int i = 3 ; i <= totalRowNum ; i++)
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
	          //设置单元格类型
	            cell1.setCellType(CellType.STRING);
	            companyinfo = cell1.getStringCellValue().trim();
	            //地区
	            Cell cell2 = row.getCell((short)2);
	            areainfo = cell2.getStringCellValue().toString().trim();
	            //邮箱
	           //Cell cell3 = row.getCell((short)3);
	           //cell3.setCellType(CellType.STRING);
	            companyemail = "*****@**.com";//cell3.getStringCellValue().toString();
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
	public int downExcelFile() {
		try {
		//创建webwook对象，和Excel表一一对应
		XSSFWorkbook workbook=new XSSFWorkbook();
		//建表
		XSSFSheet sheet=workbook.createSheet("面试信息登记表");
		//设置单元格宽度
		sheet.setColumnWidth(1, 20 * 256);  
		sheet.setColumnWidth(2, 40 * 256); 
		sheet.setColumnWidth(3, 20 * 256); 
		sheet.setColumnWidth(4, 30 * 256); 
		sheet.setColumnWidth(5, 50 * 256); 
		//设置冻结单元格
		sheet.createFreezePane(5,2,5,2 );

		// 在索引0123的位置创建行（最顶端的行）
		XSSFRow row = sheet.createRow((short)0);
		XSSFRow row1 = sheet.createRow((short)1);
		//在索引0的位置创建单元格（左上端）	
		XSSFCell cell = row.createCell(0);
		XSSFCell cell1 = row.createCell(1);
		XSSFCell cell2 = row.createCell(2);
		XSSFCell cell3 = row.createCell(3);
		XSSFCell cell4 = row.createCell(4);
		XSSFCell cell5 = row.createCell(5);
		
		//在索引1的位置创建单元格
		XSSFCell cell20 = row1.createCell(0);
		XSSFCell cell21 = row1.createCell(1);
		XSSFCell cell22 = row1.createCell(2);
		XSSFCell cell23 = row1.createCell(3);
		XSSFCell cell24 = row1.createCell(4);
		XSSFCell cell25 = row1.createCell(5);

		//设置字体样式
		XSSFFont font = workbook.createFont();
		//设置字体颜色
		font.setColor(HSSFFont.COLOR_RED);
		//设置字体大小
		font.setFontHeightInPoints((short)18);
		//设置字体粗细（未实现）
		//font.setBoldWeight(HSSFFont.);
		row.setHeight((short) (500));
		
		//定义全局样式（clone不会被覆盖）
		XSSFCellStyle tableStyle = workbook.createCellStyle();
		tableStyle.cloneStyleFrom(cell.getCellStyle());
		//自动换行
		tableStyle.setWrapText(true);
		cell.setCellStyle(tableStyle);
		//表头局部样式
		XSSFCellStyle cellStyle= workbook.createCellStyle();
		cellStyle.setFont(font);
		
		//设置水平垂直居中
		cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中  
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
		// 将样式放入第一行的单元格
		cell.setCellStyle(cellStyle);
		cell1.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell3.setCellStyle(cellStyle);
		cell4.setCellStyle(cellStyle);
		cell5.setCellStyle(cellStyle);


		// 在第一行单元格中输入一些内容
		cell.setCellValue("序号");
		cell1.setCellValue("公司名称");
		cell2.setCellValue("特点");
		cell3.setCellValue("公司地区");
		cell4.setCellValue("邮箱");
		cell5.setCellValue("其他");
		
		// 在第二行单元格中输入一些内容
		cell20.setCellValue("0");
		cell21.setCellValue("***公司");
		cell22.setCellValue("公司面试详情");
		cell23.setCellValue("深圳");
		cell24.setCellValue("填写公司邮箱");
		cell25.setCellValue("备注信息");
		 FileOutputStream fout = new FileOutputStream("H:\\第三次项目测试文档\\CreateTest.xlsx");    
         workbook.write(fout);    
         fout.close();    

		} catch (Exception e) {
			System.out.println("已运行 xlCreate() : " + e );
			return 0;
		}
		return 1;
	}

	@Override
	public int updateFlag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int upExcelFile() {
		return originaldataMapper.upExcelFile();
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
}
