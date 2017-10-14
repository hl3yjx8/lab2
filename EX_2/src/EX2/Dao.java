package EX2;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mysql.jdbc.Connection;  

import EX2.AuthorQuery;

public class Dao extends DBConnection{
   
	public static Map<Integer,AuthorQuery> books=new HashMap<Integer,AuthorQuery>();
	//用静态块进行初始化
	
	//创建数据库连接  
    Connection conn = null;  
      
    //编译执行SQL对象创建  
    java.sql.PreparedStatement pstmt = null;  
      
    //获得查询结果集对象  
    ResultSet rs = null;  
      
    @Override  
    public List<AuthorQuery> getBooks() 
    {  
        List<AuthorQuery> list = new ArrayList<AuthorQuery>();  
          
        //查询所有用户SQL文  
        String sql = " select * from book";  
          
        //执行查询操作  
        try{  
            //获得数据库连接  
            conn = this.getConnection();  
              
            //编译执行SQL文  
            pstmt = conn.prepareStatement(sql);  
              
            //或的查询结果集  
            rs = pstmt.executeQuery();  
              
            AuthorQuery user = null;  
              
            //循环获得用户信息  
            while(rs.next()){  
                //获得用户实例  
                user = new AuthorQuery();  
                //添加用户信息  
                user.setISBN(rs.getInt("id"));  
                user.setTitle(rs.getString("name"));  
                user.setAuthorID(rs.getString("age"));  
                user.setPublisher(rs.getString("email"));  
                user.setPublishDate(rs.getString("address"));  
                user.setPrice(rs.getInt("school"));  
                  
                //将用户信息添加在list中  
                list.add(user);  
            }  
              
        }catch(Exception ex)  
        {  
            //打印异常堆栈  
            ex.printStackTrace();  
        }finally{  
            //关闭和数据库操作相关的所有连接  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
        //返回用户信息  
        return list;  
    }  
    public int addUser(AuthorQuery user) {  
        //定义返回结果  
        int result = 0;  
          
        //编写添加信息SQL文  
        String sql = " insert into userinfo(name,sex,age,telephone,email,specialty,school,address) values(?,?,?,?,?,?,?,?) ";  
          
        try{  
            //获得数据库连接  
            conn = this.getConnection();  
              
            pstmt = conn.prepareStatement(sql);  
            //预编译处理  
            pstmt.setInt(1, user.getISBN());  
            pstmt.setString(2, user.getTitle());  
            pstmt.setString(3, user.getAuthorID());  
            pstmt.setString(4, user.getPublisher());  
            pstmt.setString(5, user.getPublishDate());  
            pstmt.setInt(6, user.getPrice());  
           
              
            //执行更新  
            result = pstmt.executeUpdate();  
              
            //查询是不是有添加成功  
            if(result != 0)  
            {  
                System.out.println("添加了一条用户信息！");  
            }  
              
        }catch(Exception ex)  
        {  
            //打印异常堆栈  
            ex.printStackTrace();  
        }  
        finally{  
            //关闭和数据库相关的连接  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
          
        return result;  
    }  
      
    //修改用户信息  
    @Override  
    public int updateUser(AuthorQuery user) {  
        int result;  
          
        //修改sql文：根据用户id去查询用户信息  
        String sql = " update book set ISBN=?,Title=?,AuthorID=?,Publisher=?,PublishDate=?,Price=?where ISBN ="+user.getISBN();  
          
        try  
        {  
            //获得数据库连接  
            conn = this.getConnection();  
              
            //编译执行sql文  
            pstmt = conn.prepareStatement(sql);  
              
            //预编译处理  
            pstmt.setInt(1, user.getISBN());  
            pstmt.setString(2, user.getTitle());  
            pstmt.setString(3, user.getAuthorID());  
            pstmt.setString(4, user.getPublisher());  
            pstmt.setString(5, user.getPublishDate());  
            pstmt.setInt(6, user.getPrice());  
            //执行修改  
            result = pstmt.executeUpdate();  
              
            if(result != 0)  
            {  
                System.out.println("你修改了一条记录！");  
            }  
        }  
        catch(Exception ex)  
        {  
            //打印异常堆栈  
            ex.printStackTrace();  
        }  
        finally{  
            //关闭数据库连接  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
          
        return 0;  
    }
    public int deleteUser(int uid) 
    {  
        int result = 0;  
          
        //删除用户信息sql  
        String sql = " delete from userinfo where id="+uid;//
      //执行删除
        try{
        	//获得数据库连接
        	conn = this.getConnection();
        	//编译执行
        	pstmt = conn.prepareStatement(sql);pstmt.setInt(1, uid);
        	//编译执行获得结果
        	result = pstmt.executeUpdate();
        	if(result != 0)
        	{
        		System.out.println("你删除了一条记录！");
        	}
        	
        }catch(Exception ex)
        {
        	ex.printStackTrace();}finally{this.closeAllConnection(conn,pstmt,rs);
        }return result;
    }
    
    
}