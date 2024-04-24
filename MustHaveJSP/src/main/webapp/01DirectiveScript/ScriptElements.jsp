<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!public int add(int num1, int num2) {
		return num1 + num2;
	}

	%>

<html>
<head>
<meta charset="UTF-8">
<title>함수</title>
</head>
<body>
	<%
	int result = add(10, 20);
	try {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("입력덧셈결과: "+add(num1,num2)+"<br/>");
	} catch (Exception e) {
		out.println(e.getMessage()+"<br/>");
	}
	%>
	덧셈 결과 1 :
	<%=result%>
	<br /> 덧셈 결과 2 :
	<%=add(30, 40)%>
</body>
</html>