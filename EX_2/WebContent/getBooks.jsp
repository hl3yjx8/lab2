<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ page import="EX2.Dao.*,EX2.AuthorQuery" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>用户信息一览</title>  
<style type="text/css">  
    .br_TR{  
        background-color:expression(this.rowIndex%2==0?"#CCFFFF":"FFFFCC");  
        corhur:hand;  
    }  
      
    .br_head{  
        backgroun-color:"#CCFFDD";  
    }  
</style>  
  
</head>  
<body>  
    <div align="center">  
        <h3><font color="blue">用户信息列表</font></h3>  
          
        <table width="620">  
            <tr>  
                <td align="right">增加用户</td>  
            </tr>  
        </table>  
          
        <table width="640" border="1" align="center" bordercolor="99CCFF">  
            <tr class="br_head">  
                <td>ISBN</td>  
                <td>Title</td>  
                <td>AuthorID</td>  
                <td>Publisher</td>  
                <td>PublishDate</td>  
                <td>Price</td>  
                <td>删除</td>  
                <td>修改</td>  
            </tr>  
              
            <s:iterator value="userList">  
                <tr class="br_TR">  
                    <td><s:property value="id" /></td>  
                    <td><s:property value="name" /></td>  
                    <td><s:property value="sex" /></td>  
                    <td><s:property value="age" /></td>  
                    <td><s:property value="telephone" /></td>  
                    <td><s:property value="school" /></td>  
                    <td>删除</td>  
                    <td><input type="button" name="submit" value="修改" ></td>  
                </tr>  
            </s:iterator>  
        </table>  
    </div>  
</body>  
</html>  