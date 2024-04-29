package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan02")
public class Gugudan02 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	void printVer(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html; charset=utf-8");
		for(int i=2;i<=9;i++) {
			out.println("<ul>");
			for(int j=1;j<=9;j++) {
				out.println("<li>"+i+"*"+j+"="+i*j+"</li>");
			}
			out.println("</ul>");
		}
		out.close();
	}
	void printHor(HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html; charset=utf-8");
		out.println("<table>");
		for(int i=1;i<=9;i++) {
			out.println("<tr>");
			for(int j=2;j<=9;j++) {
				out.println("<td>"+j+"*"+i+"="+i*j+"</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.close();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dir = req.getParameter("dir");
		if(dir==null)
			dir = "ver";
		if(dir.equals("ver"))
			printVer(res);
		else
			printHor(res);
			
		
	}
}
