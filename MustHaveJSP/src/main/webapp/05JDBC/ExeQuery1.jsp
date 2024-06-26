<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBK</title>
<style type="text/css">
	table{
	border-collapse:collapse;
	}
	td,th{
	padding:5px;
	border:1px solid gray;
	}
	
</style>
</head>
<body>
	<h2> 회원 목록 조회 테스트 (executeQuery()사용)</h2>
	
	<%
	JDBConnect jdbc = new JDBConnect();
	String input = request.getParameter("id");
	String sql = String.format("SELECT b.num,b.title, b.content, m.name, b.postdate, b.visitcount from member m, board b where m.id = b.id and m.id = '%s'",input);
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	out.println("<table>");
	out.println("<thead>");
	for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
		out.println("<th>"+rs.getMetaData().getColumnLabel(i)+"</th>");
	}
	out.println("</thead>");
	out.println("<tbody>");
	while(rs.next()){
		
		out.println("<tr>");
		for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
			out.println("<td>"+rs.getString(i)+"</td>");
		}
		
		out.println("</tr>");
	}
	out.println("</tbody>");
	out.println("</table>");
	
	
	jdbc.close();
	%>
</body>
</html>