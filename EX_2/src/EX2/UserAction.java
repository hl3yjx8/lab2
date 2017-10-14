package EX2;
import java.util.Map;


import org.apache.struts2.interceptor.RequestAware;


public class UserAction implements RequestAware{
	private Integer ISBN;
	private Dao dao=new Dao();
	private Map<String, Object> request=null;
	//��Ҫ�ڵ�ǰ��EmployeeAction����EmployeeId���ԣ������������
   public Integer getISBN() 
   {
	   return ISBN;
   }
   public void setISBN(Integer ISBN) 
	{
		this.ISBN = ISBN;
	}
   public String list()
   {
	   request.put("books", dao.getBooks());
	   return "list";
   }
   public String delete()
   {
	   dao.deleteUser(ISBN);
	   //���ؽ������,ΪredirectAction;
	   return "delete";
   }
   @Override
   public void setRequest(Map<String, Object> request) 
   {
	   this.request=request;
   }
}