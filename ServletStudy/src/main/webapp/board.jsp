
<%@ page import = "common.BoardDAO" %>
<%@ page import = "common.BoardDTO" %>
<%@ page import = "java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO(application);
List<BoardDTO> boardLists = dao.selectList();
request.setAttribute("boardLists",boardLists);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<c:forEach items="<%= boardLists %>" var="c" varStatus="loop">
		<tr>
		<td align = "center"> ${c.id}</td>
		<td align = "center">${c.title }</td>
		<td align = "center">${c.visitcount }</td>
		<td align = "center">${c.postdate }</td>
		</tr>
	</c:forEach>
	<% 
	for(BoardDTO dto : boardLists){
		%>
		<tr>
		<td align = "center"><%= dto.getId() %></td>
		<td align = "center"><%= dto.getTitle() %></td>
		<td align = "center"><%= dto.getVisitcount() %></td>
		<td align = "center"><%= dto.getPostdate() %></td>
		</tr>
	<% 
	}
	%>
	
	
</table>
</body>
</html>