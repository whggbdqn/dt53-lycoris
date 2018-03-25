package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.Indexes;

public interface DataProcessingService {
	 @SuppressWarnings("rawtypes")
	Map initKeyWord();
		/**
		 * 导入关键字集合,转换成DFA算法
		 * @author ss
		 * @date 2018-3-25
		 * @param keyWordSet  
		 * @version 1.0
		 */
	 void addSensitiveWordToHashMap(Set<String> keyWordSet);
	 /**
		 * 获取索引表添加到set集合
		 * @author ss
		 * @date 2018-3-25
		 * @return
		 * @version 1.0
		 * @throws Exception 
		 */
	 Set<String> readSensitiveWordFile() throws Exception;
	 boolean isContaintSensitiveWord(String txt,int matchType);
	 Set<String> getSensitiveWord(String txt , int matchType);
	 String replaceSensitiveWord(String txt,int matchType,String replaceChar);
	 String getReplaceChars(String replaceChar,int length);
	 int CheckSensitiveWord(String txt,int beginIndex,int matchType);
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
