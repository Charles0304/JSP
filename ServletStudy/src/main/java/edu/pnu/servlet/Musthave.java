package edu.pnu.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/musthave")
public class Musthave extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table=req.getParameter("table");
		if(table==null)
			table = "board";
		
		if(table.equals("member"))
			req.getRequestDispatcher("member.jsp").forward(req, res);
		else
			req.getRequestDispatcher("board.jsp").forward(req, res);
	}

}
