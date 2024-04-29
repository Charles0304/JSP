package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/myservlet04")
public class MyServlet04 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<table>");
		out.println("<thead><tr><th>번호</th><th>나라</th><th>수도</th></tr></thead>");
		out.println("<tbody");
		out.println("<tr><td>1</td><td>대한민국</td><td>서울</td></tr>");
		out.println("<tr><td>2</td><td>미국</td><td>워싱턴</td></tr>");
		out.println("<tr><td>3</td><td>일본</td><td>도쿄</td></tr>");
		out.println("<tr><td>4</td><td>중국</td><td>베이징</td></tr>");
		out.println("</tbody");
		out.println("</table>");
		out.close();
	}
}
