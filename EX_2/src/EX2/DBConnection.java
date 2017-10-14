package EX2;  
  
import java.sql.DriverManager;  
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.Connection;  
//import com.mysql.jdbc.PreparedStatement;  
import java.sql.PreparedStatement;  
  
/** 
 * 数据库操作父类：连接和关闭数据库 
 * @author peixun 
 * 
 */  
public class DBConnection {  
  
    /** 
     * 获得数据库连接 
     * @return 
     */  
    public Connection getConnection()  
    {  
        //初始化一个数据库连接  
        Connection conn = null;  
          
        try{  
            //加载Mysql数据库驱动  
            Class.forName("com.mysql.jdbc.Driver");  
            //与数据库建立连接  
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "910214");  
        }catch(Exception ex){  
            //打印异常堆栈  
            ex.printStackTrace();  
        }  
        //返回数据库连接  
        return conn;  
    }  
      
    /** 
     * 关闭数据库相关的连接 
     * @param conn  数据库连接 
     * @param pstmt  编译执行SQL对象 
     * @param set 结果集 
     */  
    public void closeAllConnection(Connection conn, PreparedStatement pstmt,ResultSet rs)  
    {  
        if(rs != null)  
        {  
            try{  
                //关闭结果集对象  
                rs.close();  
            }catch(Exception ex)  
            {  
                ex.printStackTrace();  
            }  
        }  
          
        if(pstmt != null)  
        {  
            try{  
                pstmt.close();//关闭编译执行SQL对象  
            }catch(Exception ex)  
            {  
                ex.printStackTrace();  
            }  
        }  
          
        if(conn != null)  
        {  
            try{  
                conn.close();//关闭数据库连接对象  
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