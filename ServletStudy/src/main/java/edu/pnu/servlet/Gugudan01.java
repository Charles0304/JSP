package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan01")
public class Gugudan01 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String snum = req.getParameter("num");
		int num = 2;
		if(snum!=null) {
			num = Integer.parseInt(snum);
		}
		out.println("<h2>"+num+"단입니다.</h2>");
		out.println("<ul>");
		for(int i=1;i<=9;i++) {
			out.println("<li>"+num+"*"+i+"="+num*i+"</li>");
		}
		out.println("</ul>");
		out.close();
	}
}
