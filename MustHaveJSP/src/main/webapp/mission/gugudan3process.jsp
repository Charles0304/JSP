<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String sel = request.getParameter("type");
	int num = Integer.parseInt(request.getParameter("num"));
	if(sel.equals("type1")){
		response.sendRedirect(String.format("gugudan1.jsp?dan=%d",num));
	}else{
		response.sendRedirect(String.format("gugudan2.jsp?col=%d",num));
	}
%>
