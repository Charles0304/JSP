<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "common.Person" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어 (EL - 컬렉션)</title>
</head>
<body>
	<h2>List 컬렉션</h2>
	<%
	Map<String,String> map = new HashMap<String, String>();
	map.put("한글","훈민정음");
	map.put("Eng","English");
	pageContext.setAttribute("King",map);
	%>
	<ul>
		<li>영문 key : ${King["Eng"] }, ${King['Eng'] },${ King.Eng}</li>
		<li>한글 key : ${King["한글"] }, ${ King['한글'] }, \${King.한글 }</li>
	</ul>
</body>
</html>