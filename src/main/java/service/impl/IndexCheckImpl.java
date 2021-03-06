package service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Indexes;
import service.IndexCheck;
import service.IndexesService;
import util.SensitivewordFilter;

@Component("indexCheck")
public class IndexCheckImpl implements IndexCheck {
	
	@Autowired
	private IndexesService indexesService;
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;
	public static int minMatchTYpe = 1;  
	public static int maxMatchType = 2;   
	@Override
	@SuppressWarnings("rawtypes")
	public Map initKeyWord(int indexClass){
		try {
			Set<String> keyWordSet = readSensitiveWordFile(indexClass);
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
	public Set<String> readSensitiveWordFile(int indexClass) throws Exception{
		Set<String> set = null;
		List<Indexes> list=null;
		if(indexClass==1){
		 list=indexesService.getFirstClassIndex();//获取一级索引
		}else {
		 list=indexesService.getSecondClassIndex();//获取二级索引
		}
				set = new HashSet<String>();
			for (Indexes indexes : list) {
					set.add(indexes.getIndexinfo());
			}
		return set;
	}
	@Override
	public boolean isContaintSensitiveWord(String txt, int matchType,int indexClass) {
		boolean flag = false;
		for(int i = 0 ; i < txt.length() ; i++){
			int matchFlag = this.CheckSensitiveWord(txt, i, matchType,indexClass); 
			if(matchFlag > 0){    
				flag = true;
			}
		}
		return flag;
	}
	@Override
	public Set<String> getSensitiveWord(String companyinfo, int matchType,int indexClass) {
		Set<String> sensitiveWordList = new HashSet<String>();
		for(int i = 0 ; i < companyinfo.length() ; i++){
			int length = CheckSensitiveWord(companyinfo, i, matchType, indexClass);     
			if(length > 0){    
				sensitiveWordList.add(companyinfo.substring(i, i+length));
				i = i + length - 1;   
			}
		}
		return sensitiveWordList;
	}
	@Override
	public Map<String, Object> replaceSensitiveWord(String companyinfo, int matchType, String replaceChar,int indexClass) {
		String resultTxt = companyinfo;
		Map<String,Object> map=new HashMap<String,Object>();
		Set<String> set = getSensitiveWord(companyinfo, matchType, indexClass);  
		//得到第一次处理结果
		map.put("sensitiveWordList", set);
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		//得到处理后公司信息
		map.put("companyinfo", resultTxt);
		return map;
	}
	@Override
	public String getReplaceChars(String replaceChar, int length ) {
		String resultReplace = replaceChar;
		for(int i = 1 ; i < length ; i++){
			resultReplace += replaceChar;
		}
		return resultReplace;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public int CheckSensitiveWord(String companyinfo, int beginIndex, int matchType,int indexClass) {
		boolean  flag = false;    
		int matchFlag = 0;     
		char word = 0;
		Map nowMap = this.initKeyWord(indexClass);
		for(int i = beginIndex; i < companyinfo.length() ; i++){
			word = companyinfo.charAt(i);
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
}
