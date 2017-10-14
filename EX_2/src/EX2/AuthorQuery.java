package EX2;
public class AuthorQuery {

private Integer ISBN;
private String Title;
private String AuthorID;
private String Publisher;
private String PublishDate;
private Integer Price;

public AuthorQuery() 
{
	super();
	this.ISBN = ISBN;
	this.Title = Title;
	this.AuthorID = AuthorID;
	this.Publisher = Publisher;
	this.PublishDate = PublishDate;
	this.Price = Price;
}
public Integer getISBN() 
{
	return ISBN;
}
public void setISBN(Integer ISBN) 
{
	this.ISBN = ISBN;
}
public String getTitle() 
{
	return Title;
}
public void setTitle(String Title) 
{
	this.Title = Title;
}
public String getAuthorID() 
{
	return AuthorID;
}
public void setAuthorID(String AuthorID) 
{
	this.AuthorID = AuthorID;
}
public String getPublisher() 
{
	return Publisher;
}
public void setPublisher(String Publisher) 
{
	this.Publisher = Publisher;
}
public String getPublishDate() 
{
	return PublishDate;
}
public void setPublishDate(String PublishDate) 
{
	this.PublishDate = PublishDate;
}public Integer getPrice() 
{
	return Price;
}
public void setPrice(Integer Price) 
{
	this.Price = Price;
}
@Override
public String toString() 
{
	return "Book [ISBN=" + ISBN + ", Title=" + Title+ ", AuthodID=" + AuthorID + ", Publisher="
+ Publisher + ",PublishDate=" + PublishDate +",Price" + Price +"]";
}


}