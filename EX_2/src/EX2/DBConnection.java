package EX2;  
  
import java.sql.DriverManager;  
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.Connection;  
//import com.mysql.jdbc.PreparedStatement;  
import java.sql.PreparedStatement;  
  
/** 
 * ���ݿ�������ࣺ���Ӻ͹ر����ݿ� 
 * @author peixun 
 * 
 */  
public class DBConnection {  
  
    /** 
     * ������ݿ����� 
     * @return 
     */  
    public Connection getConnection()  
    {  
        //��ʼ��һ�����ݿ�����  
        Connection conn = null;  
          
        try{  
            //����Mysql���ݿ�����  
            Class.forName("com.mysql.jdbc.Driver");  
            //�����ݿ⽨������  
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "910214");  
        }catch(Exception ex){  
            //��ӡ�쳣��ջ  
            ex.printStackTrace();  
        }  
        //�������ݿ�����  
        return conn;  
    }  
      
    /** 
     * �ر����ݿ���ص����� 
     * @param conn  ���ݿ����� 
     * @param pstmt  ����ִ��SQL���� 
     * @param set ����� 
     */  
    public void closeAllConnection(Connection conn, PreparedStatement pstmt,ResultSet rs)  
    {  
        if(rs != null)  
        {  
            try{  
                //�رս��������  
                rs.close();  
            }catch(Exception ex)  
            {  
                ex.printStackTrace();  
            }  
        }  
          
        if(pstmt != null)  
        {  
            try{  
                pstmt.close();//�رձ���ִ��SQL����  
            }catch(Exception ex)  
            {  
                ex.printStackTrace();  
            }  
        }  
          
        if(conn != null)  
        {  
            try{  
                conn.close();//�ر����ݿ����Ӷ���  
            }catch(Exception ex){  
                ex.printStackTrace();  
            }  
        }  
    }

	public List<AuthorQuery> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUser(AuthorQuery user) {
		// TODO Auto-generated method stub
		return 0;
	}  
}  