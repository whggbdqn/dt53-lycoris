package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class intoDatab {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String txt ="";
		String sql = "insert into indexes (indexinfo) values (?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lycorisproject","root","123456");
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		File file=new File("D://aaa.txt");
		InputStreamReader read=new InputStreamReader(new FileInputStream(file),"GBK");
		try {
			if(file.isFile() && file.exists()){      //�ļ����Ƿ����
				BufferedReader bufferedReader = new BufferedReader(read);
				while((txt = bufferedReader.readLine()) != null){    //��ȡ�ļ������ļ����ݷ��뵽set��
					ps.setObject(1, txt);
					ps.execute();
			    }
			}
			else{         //�������׳��쳣��Ϣ
				throw new Exception("���дʿ��ļ�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			read.close();     //�ر��ļ���
		}
	}
}
