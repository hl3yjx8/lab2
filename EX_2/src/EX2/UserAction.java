package EX2;
import java.util.Map;


import org.apache.struts2.interceptor.RequestAware;


public class UserAction implements RequestAware{
	private Integer ISBN;
	private Dao dao=new Dao();
	private Map<String, Object> request=null;
	//需要在当前的EmployeeAction定义EmployeeId属性，接收请求参数
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
	   //返回结果类型,为redirectAction;
	   return "delete";
   }
   @Override
   public void setRequest(Map<String, Object> request) 
   {
	   this.request=request;
   }
}