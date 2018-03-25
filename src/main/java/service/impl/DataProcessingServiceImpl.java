package service.impl;

import service.DataProcessingService;
import service.IndexesService;

import java.applet.AppletContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Indexes;
@Component("dataProcessing")
public class DataProcessingServiceImpl implements DataProcessingService {
	@Autowired
	private IndexesService indexService;
		@SuppressWarnings("rawtypes")
		public HashMap sensitiveWordMap;
		@SuppressWarnings("rawtypes")
		public Map initKeyWord(){
			try {
				Set<String> keyWordSet = readSensitiveWordFile();
				addSensitiveWordToHashMap(keyWordSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sensitiveWordMap;
		}
		/**
		 * 导入关键字集合,转换成DFA算法
		 * @author ss
		 * @date 2018-3-25
		 * @param keyWordSet  
		 * @version 1.0
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void addSensitiveWordToHashMap(Set<String> keyWordSet) {
			sensitiveWordMap = new HashMap(keyWordSet.size());    
			String key = null;  
			Map nowMap = null;
			Map<String, String> newWorMap = null;
			Iterator<String> iterator = keyWordSet.iterator();
			while(iterator.hasNext()){
				key = iterator.next();    
				nowMap = sensitiveWordMap;
				for(int i = 0 ; i < key.length() ; i++){
					char keyChar = key.charAt(i);    
					Object wordMap = nowMap.get(keyChar);       
					if(wordMap != null){  
						nowMap = (Map) wordMap;
					}
					else{ 
						newWorMap = new HashMap<String,String>();
						newWorMap.put("isEnd", "0");  //非关键词结尾
						nowMap.put(keyChar, newWorMap);
						nowMap = newWorMap;
					}
					if(i == key.length() - 1){
						nowMap.put("isEnd", "1");    //关键词结尾
					}
				}
			}
		}

		/**
		 * 获取索引表添加到set集合
		 * @author ss
		 * @date 2018-3-25
		 * @return
		 * @version 1.0
		 * @throws Exception 
		 */
		public Set<String> readSensitiveWordFile() throws Exception{
			Set<String> set = null;
			List<Indexes> list=indexService.getFirstClassIndex();
					set = new HashSet<String>();
				for (Indexes indexes : list) {
						set.add(indexes.getIndexinfo());
				}
				for (String s : set) {
					System.out.println(s);
				}
			return set;
		}
	}
