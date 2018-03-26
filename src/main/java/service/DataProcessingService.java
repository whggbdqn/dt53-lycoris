package service;

import java.util.Set;

public interface DataProcessingService {
	 /**
	  * 第一次过滤,返回一级关键词集合
	  * @author ss
	  * @date 2018-3-25
	  */
	 Set<String> FirstGo(String companyinfo);//传入数据OriginalData.companyinfo
	 /**
	  * 第二次过滤,返回二级关键词集合
	  * @author ss
	  * @date 2018-3-25
	  */
	 Set<String> SecondGo(String companyinfo);//传入数据OriginalData.companyinfo
	 /**
		 * 数据处理
		 * @author ss
		 * @date 2018-3-25
		 */
	 int DataGo();
	 
}
