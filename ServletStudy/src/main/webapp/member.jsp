
<%@ page import="common.MemberDAO"%>
<%@ page import="common.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDAO dao = new MemberDAO(application);
List<MemberDTO> MemberLists = dao.selectList();
request.setAttribute("list",MemberLists);
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
		<c:forEach var="dto" items="${list}">
			<tr>
				<td align="center"><c:out value="${dto.id}" /></td>
				<td align="center"><c:out value="${dto.pass}" /></td>
				<td align="center"><c:out value="${dto.name}" /></td>
				<td align="center"><c:out value="${dto.regidate}" /></td>
			</tr>
		</c:forEach>
		<% 
	for(MemberDTO dto : MemberLists){
		%>
		<tr>
			<td align="center"><%= dto.getId() %></td>
			<td align="center"><%= dto.getPass() %></td>
			<td align="center"><%= dto.getName() %></td>
			<td align="center"><%= dto.getRegidate() %></td>

		</tr>
		<% 
	}
	%>


	</table>
</body>
</html>