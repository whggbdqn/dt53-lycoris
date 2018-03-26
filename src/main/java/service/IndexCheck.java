package service;

import java.util.Map;
import java.util.Set;

public interface IndexCheck {
	@SuppressWarnings("rawtypes")
	Map initKeyWord(int indexClass);
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
	 Set<String> readSensitiveWordFile(int indexClass) throws Exception;
	 boolean isContaintSensitiveWord(String txt,int matchType,int indexClass);
	 Set<String> getSensitiveWord(String txt , int matchType,int indexClass);
	 String replaceSensitiveWord(String txt,int matchType,String replaceChar,int indexClass);
	 String getReplaceChars(String replaceChar,int length );
	 int CheckSensitiveWord(String txt,int beginIndex,int matchType,int indexClass);
}
