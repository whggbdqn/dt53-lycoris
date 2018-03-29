package util;


import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 创建Excel表格工具类
 * @author zhangzhe
 * Date：3-27
 */
public class ExcelUtil {
	public static void exportExcel(ServletOutputStream outputStream) throws Exception{
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
			// FileOutputStream fout = new FileOutputStream("H:\\第三次项目测试文档\\CreateTest.xlsx");    
	         workbook.write(outputStream);    
	         workbook.close();    

			} catch (Exception e) {
				System.out.println("已运行 xlCreate() : " + e );
			}
			    System.out.println("文件生成成功");
		}

}
