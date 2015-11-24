<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*,com.huel.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
		ResultSet GoodsList = request.getAttribute("books");
	%>



	本站提供的图书有：
	<br>
	<form>
		<%
			String url;
			while(GoodsList.next()) {
			 url = "/Shopping/PurchaseServlet?id=" +  GoodsList.getString(1);
		%>
		<%=GoodsList.getString(2)%>
		<a href='javascript:getElementById(<%=GoodsList.getString(1)%>num).value=getElementById(<%=GoodsList.getString(1)%>num).value-1;'>-</a><input type='text' id='<%=GoodsList.getString(1)%>num' value=''> <a href='javascript:getElementById(<%=GoodsList.getString(1)%>num).value=getElementById(<%=GoodsList.getString(1)%>num).value+1'>+</a>
		<a href='javascript:Treat(<%=GoodsList.getString(1)%>)'>点击购买</a><br>
		<%
		}
		%>		
	</form>	

<script type="text/javascript">
function Treat(id)
{
   var url="/Shopping_11_18/PurchaseServlet?";
   url=url+"id="+id;
   url=url+"&num="+document.getElementById(id+"num").value;
   window.location.href=url;
}

</script>


</body>
</html>