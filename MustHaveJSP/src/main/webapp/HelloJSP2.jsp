<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String str1 = "JSP";
String getMessage(String str1){
	if (str1 == null)
		return "null입니다";
	else if(str1.equals("java"))
		return "열공합시다";
	return "빡세게 합시다.";
}
	%>
<%
String str2 = request.getParameter("lang");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h2>
		처음 만들어보는
		<%=str2%></h2>
	<p>
		<%
		
		
		if(str2==null)
			out.println("입력해주세요");
		
		else
			out.println(str2 + "입니다."+getMessage(str2));
		%>
	</p>
</body>
</html>