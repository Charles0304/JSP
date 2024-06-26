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
	td{
	padding:5px;
	border:1px solid gray;
	}
	
</style>
</head>
<body>
	<h2> 회원 목록 조회 테스트 (executeQuery()사용)</h2>
	
	<%
	JDBConnect jdbc = new JDBConnect();
	
	String sql = "SELECT id, pass, name, regidate from member";
	
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	out.println("<table>");
	out.println(String.format("<thead><tr><th>%s</th> <th>%s</th> <th>%s</th> <th>%s</th></tr></thead>",
			rs.getMetaData().getColumnLabel(1),rs.getMetaData().getColumnLabel(2),rs.getMetaData().getColumnLabel(3),rs.getMetaData().getColumnLabel(4)));
	out.println("<tbody>");
	while(rs.next()){
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.println(String.format("<tr><td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",id,pw,name,regidate));
	}
	out.println("</tbody>");
	out.println("</table>");
	
	
	jdbc.close();
	%>
</body>
</html>