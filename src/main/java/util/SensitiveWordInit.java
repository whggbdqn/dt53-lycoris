package util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * @Description: ��ʼ�����дʿ⣬�����дʼ��뵽HashMap�У�����DFA�㷨ģ��
 * @Project��test
 * @Author : chenming
 * @Date �� 2014��4��20�� ����2:27:06
 * @version 1.0
 */
public class SensitiveWordInit {
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;
	public SensitiveWordInit(){
		super();
	}
	
	/**
	 * @author chenming 
	 * @date 2014��4��20�� ����2:28:32
	 * @version 1.0
	 */
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
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
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
	private Set<String> readSensitiveWordFile() throws Exception{
		Set<String> set = null;
		try {
			String sql = "select indexinfo from matchindex where indexclass=2";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lycorisproject","root","123456");
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
				set = new HashSet<String>();
				ResultSet rs=(ResultSet) ps.executeQuery();
				while(rs.next()){
						set.add(rs.getString(1));
				}
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			System.out.println(set.size());
		}
		return set;
	}
}
