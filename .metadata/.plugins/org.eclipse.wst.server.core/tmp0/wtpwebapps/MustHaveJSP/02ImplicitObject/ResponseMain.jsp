<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 = response</title>
</head>
<body>
	<h2>1.로그인 폼</h2>
	<%
	String loginErr = request.getParameter("loginErr");
	if (loginErr != null)
		out.print("로그인 실패");
	%>
	<form action="./ResponseLogin.jsp" method="post">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="user_id" /><br /></td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input type="password" name="user_pwd" /><br /></td>
			</tr>
		</table>


		<input type="submit" value="login" />
	</form>

	<h2>2. HTTP 응답 헤더 설정하기</h2>
	<form action="./ResponseHeader.jsp" method="get">
		날짜 형식 : <input type="text" name="add_date" value="2021-10-25 09:00" />
		<br /> 숫자 형식 : <input type="text" name="add_int" value="8282" /> <br />
		문자 형식 : <input type="text" name="add_str" value="홍길동" /><br /> <input
			type="submit" value="응답 헤더 설정 & 출력" />
	</form>
</body>
</html>