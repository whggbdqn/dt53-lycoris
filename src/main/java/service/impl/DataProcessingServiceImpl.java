package service.impl;

import service.DataProcessingService;
import service.IndexesService;
import util.SensitivewordFilter;

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
		public static int minMatchTYpe = 1;  
		public static int maxMatchType = 2;   
		
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
		@Override
		public boolean isContaintSensitiveWord(String txt, int matchType) {
			boolean flag = false;
			for(int i = 0 ; i < txt.length() ; i++){
				int matchFlag = this.CheckSensitiveWord(txt, i, matchType); //�ж��Ƿ���������ַ�
				if(matchFlag > 0){    
					flag = true;
				}
			}
			return flag;
		}
		@Override
		public Set<String> getSensitiveWord(String txt, int matchType) {
			Set<String> sensitiveWordList = new HashSet<String>();
			for(int i = 0 ; i < txt.length() ; i++){
				int length = CheckSensitiveWord(txt, i, matchType);     
				if(length > 0){    
					sensitiveWordList.add(txt.substring(i, i+length));
					i = i + length - 1;   
				}
			}
			return sensitiveWordList;
		}
		@Override
		public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
			String resultTxt = txt;
			Set<String> set = getSensitiveWord(txt, matchType);     //��ȡ���е����д�
			Iterator<String> iterator = set.iterator();
			String word = null;
			String replaceString = null;
			while (iterator.hasNext()) {
				word = iterator.next();
				replaceString = getReplaceChars(replaceChar, word.length());
				resultTxt = resultTxt.replaceAll(word, replaceString);
			}
			
			return resultTxt;
		}
		@Override
		public String getReplaceChars(String replaceChar, int length) {
			String resultReplace = replaceChar;
			for(int i = 1 ; i < length ; i++){
				resultReplace += replaceChar;
			}
			return resultReplace;
		}
		@SuppressWarnings("rawtypes")
		@Override
		public int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
			boolean  flag = false;    
			int matchFlag = 0;     
			char word = 0;
			Map nowMap = sensitiveWordMap;
			for(int i = beginIndex; i < txt.length() ; i++){
				word = txt.charAt(i);
				nowMap = (Map) nowMap.get(word);   
				if(nowMap != null){    
					matchFlag++;    
					if("1".equals(nowMap.get("isEnd"))){      
						flag = true;      
						if(SensitivewordFilter.minMatchTYpe == matchType){    
							break;
						}
					}
				}
				else{   
					break;
				}
			}
			if(matchFlag < 1 || !flag){     
				matchFlag = 0;
			}
			return matchFlag;
		}
		/**
		  * 第一次过滤,返回一级关键词集合
		  * @author ss
		  * @date 2018-3-25
		  */
		@Override
		public List<Indexes> FirstGo() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
