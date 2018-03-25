package service;

import java.util.Map;
import java.util.Set;

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

}
