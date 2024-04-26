package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/12Servlet/DirectServletPrint.do")
public class DirectServletPrint extends HttpServlet {
	
	private static final long serialVersionUID= 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head><title>DirectServletPrint</title></head>");
		writer.println("<body>");
		writer.println("<h2> 서블릿에서 직접 출력하지 않습니다");
		writer.println("<p>jsp로 포워드 하지 않습니다");
		writer.println("/body");
		writer.println("/html");
		writer.close();
	}

}
