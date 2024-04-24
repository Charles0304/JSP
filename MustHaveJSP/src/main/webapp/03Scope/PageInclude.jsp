<%@ page import = "common.Person" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Include 페이지</h4>
	<%
	int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
	Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
	<li>Integer Object : <%= pInteger2 %></li>
	<li>String Object : <%= pageContext.getAttribute("pageString") %></li>
	<li>Person Object : <%= pPerson2.getName() %>, <%= pPerson2.getAge() %></li>
	</ul>
</body>
</html>