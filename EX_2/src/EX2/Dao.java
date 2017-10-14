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
	//�þ�̬����г�ʼ��
	
	//�������ݿ�����  
    Connection conn = null;  
      
    //����ִ��SQL���󴴽�  
    java.sql.PreparedStatement pstmt = null;  
      
    //��ò�ѯ���������  
    ResultSet rs = null;  
      
    @Override  
    public List<AuthorQuery> getBooks() 
    {  
        List<AuthorQuery> list = new ArrayList<AuthorQuery>();  
          
        //��ѯ�����û�SQL��  
        String sql = " select * from book";  
          
        //ִ�в�ѯ����  
        try{  
            //������ݿ�����  
            conn = this.getConnection();  
              
            //����ִ��SQL��  
            pstmt = conn.prepareStatement(sql);  
              
            //��Ĳ�ѯ�����  
            rs = pstmt.executeQuery();  
              
            AuthorQuery user = null;  
              
            //ѭ������û���Ϣ  
            while(rs.next()){  
                //����û�ʵ��  
                user = new AuthorQuery();  
                //����û���Ϣ  
                user.setISBN(rs.getInt("id"));  
                user.setTitle(rs.getString("name"));  
                user.setAuthorID(rs.getString("age"));  
                user.setPublisher(rs.getString("email"));  
                user.setPublishDate(rs.getString("address"));  
                user.setPrice(rs.getInt("school"));  
                  
                //���û���Ϣ�����list��  
                list.add(user);  
            }  
              
        }catch(Exception ex)  
        {  
            //��ӡ�쳣��ջ  
            ex.printStackTrace();  
        }finally{  
            //�رպ����ݿ������ص���������  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
        //�����û���Ϣ  
        return list;  
    }  
    public int addUser(AuthorQuery user) {  
        //���巵�ؽ��  
        int result = 0;  
          
        //��д�����ϢSQL��  
        String sql = " insert into userinfo(name,sex,age,telephone,email,specialty,school,address) values(?,?,?,?,?,?,?,?) ";  
          
        try{  
            //������ݿ�����  
            conn = this.getConnection();  
              
            pstmt = conn.prepareStatement(sql);  
            //Ԥ���봦��  
            pstmt.setInt(1, user.getISBN());  
            pstmt.setString(2, user.getTitle());  
            pstmt.setString(3, user.getAuthorID());  
            pstmt.setString(4, user.getPublisher());  
            pstmt.setString(5, user.getPublishDate());  
            pstmt.setInt(6, user.getPrice());  
           
              
            //ִ�и���  
            result = pstmt.executeUpdate();  
              
            //��ѯ�ǲ�������ӳɹ�  
            if(result != 0)  
            {  
                System.out.println("�����һ���û���Ϣ��");  
            }  
              
        }catch(Exception ex)  
        {  
            //��ӡ�쳣��ջ  
            ex.printStackTrace();  
        }  
        finally{  
            //�رպ����ݿ���ص�����  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
          
        return result;  
    }  
      
    //�޸��û���Ϣ  
    @Override  
    public int updateUser(AuthorQuery user) {  
        int result;  
          
        //�޸�sql�ģ������û�idȥ��ѯ�û���Ϣ  
        String sql = " update book set ISBN=?,Title=?,AuthorID=?,Publisher=?,PublishDate=?,Price=?where ISBN ="+user.getISBN();  
          
        try  
        {  
            //������ݿ�����  
            conn = this.getConnection();  
              
            //����ִ��sql��  
            pstmt = conn.prepareStatement(sql);  
              
            //Ԥ���봦��  
            pstmt.setInt(1, user.getISBN());  
            pstmt.setString(2, user.getTitle());  
            pstmt.setString(3, user.getAuthorID());  
            pstmt.setString(4, user.getPublisher());  
            pstmt.setString(5, user.getPublishDate());  
            pstmt.setInt(6, user.getPrice());  
            //ִ���޸�  
            result = pstmt.executeUpdate();  
              
            if(result != 0)  
            {  
                System.out.println("���޸���һ����¼��");  
            }  
        }  
        catch(Exception ex)  
        {  
            //��ӡ�쳣��ջ  
            ex.printStackTrace();  
        }  
        finally{  
            //�ر����ݿ�����  
            this.closeAllConnection(conn, pstmt, rs);  
        }  
          
        return 0;  
    }
    public int deleteUser(int uid) 
    {  
        int result = 0;  
          
        //ɾ���û���Ϣsql  
        String sql = " delete from userinfo where id="+uid;//
      //ִ��ɾ��
        try{
        	//������ݿ�����
        	conn = this.getConnection();
        	//����ִ��
        	pstmt = conn.prepareStatement(sql);pstmt.setInt(1, uid);
        	//����ִ�л�ý��
        	result = pstmt.executeUpdate();
        	if(result != 0)
        	{
        		System.out.println("��ɾ����һ����¼��");
        	}
        	
        }catch(Exception ex)
        {
        	ex.printStackTrace();}finally{this.closeAllConnection(conn,pstmt,rs);
        }return result;
    }
    
    
}