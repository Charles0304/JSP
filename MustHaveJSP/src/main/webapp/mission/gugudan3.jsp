<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gugudan3process.jsp" method = "post">
		<input type = "radio"  name = "type" value="type1" checked/>
		<label for ="type1">type1</label>
		<input type = "radio"  name = "type" value="type2"/>
		<label for ="type2">type2</label>
		<br/>
		<input type="text" id = "num" name = "num"/>
		<label for ="num">단수/열수</label>
		<br/>
		<input type = "submit" value = "select"/>
	</form>
</body>
</html>