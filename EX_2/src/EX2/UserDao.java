package EX2;  
  
import java.util.List;  
  
import EX2.AuthorQuery;  
  
/** 
 * 用户操作接口：定义用户的基本操作 
 * @author peixun 
 * 
 */  
public interface UserDao {  
  
    //查询出所有记录  
    public List<AuthorQuery> getBooks();  
      
    //根据主键查询出一条已有的记录  
    public AuthorQuery getUserById(int uid);  
      
    //添加一个用户  
    public int addUser(AuthorQuery user);  
      
    //更新用户：按照主键修改  
    public int updateUser(AuthorQuery user);  
      
    //删除用户:通过主键删除  
    public int deleteUser(int uid);  
      
}  