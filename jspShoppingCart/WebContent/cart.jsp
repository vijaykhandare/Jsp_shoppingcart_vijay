<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<a href="index.jsp">continue shopping</a>

<form action="shoppingServlet?action=update" method="post">
<table cellpadding="2" cellspacing="2" border="1">


<tr>

<th>Option</th>
<th>Id</th>
<th>Name</th>
<th>price</th>
<th>quantity<input type="submit" value="update" >  </th>
<th>sub total</th>



</tr>
<c:set var="s" value="0"></c:set>
<c:forEach var="it" items="${sessionScope.cart}">
<c:set var="s" value="${s+it.p.price * it.quantity}"></c:set>
<tr>

<td align="center" ><a href="shoppingServlet?id=${it.p.id}&action=delete" onclick="return confirm('are you sure')">Delete</a></td>
<td>${it.p.id}</td>
<td>${it.p.name}</td>
<td>${it.p.price}</td>
<td><input type="text" name="quantity" value="${it.quantity}" style="width: 60px;">  </td>
<td>${it.p.price * it.quantity }</td>

</tr>




</c:forEach>

<tr>
<td  colspan="5" align="right">sum</td>
<td>${s}</td>


</tr>
</table>
</form>
</body>
</html>