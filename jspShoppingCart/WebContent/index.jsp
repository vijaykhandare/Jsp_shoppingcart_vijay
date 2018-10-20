<%@page import="com.model.BLManager"%>
<%@page import="com.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
BLManager bl=new BLManager();


List<Product> plist=bl.serchbyproduct();
session.setAttribute("plist", plist);
%>
<a href="ShoppingCart.jsp">Shopping Cart Quantity:</a>
    <%= %>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp Shopping cart </title>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="1">
<tr>

<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Buy</th>




</tr>

<c:forEach var="l"  items="${sessionScope.plist}">
<tr>
<td>${l.id}</td>
<td>${l.name}</td>
<td>${l.price}</td>
<td align="center"><a href="shoppingServlet?id=${l.id}&action=ordernow">Order now</a></td>
</tr>	
</c:forEach>

</table>
</body>
</html>