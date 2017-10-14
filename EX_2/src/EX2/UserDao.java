package EX2;  
  
import java.util.List;  
  
import EX2.AuthorQuery;  
  
/** 
 * �û������ӿڣ������û��Ļ������� 
 * @author peixun 
 * 
 */  
public interface UserDao {  
  
    //��ѯ�����м�¼  
    public List<AuthorQuery> getBooks();  
      
    //����������ѯ��һ�����еļ�¼  
    public AuthorQuery getUserById(int uid);  
      
    //���һ���û�  
    public int addUser(AuthorQuery user);  
      
    //�����û������������޸�  
    public int updateUser(AuthorQuery user);  
      
    //ɾ���û�:ͨ������ɾ��  
    public int deleteUser(int uid);  
      
}  