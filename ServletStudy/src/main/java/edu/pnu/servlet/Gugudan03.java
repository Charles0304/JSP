package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan03")
public class Gugudan03 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		String scol = req.getParameter("dan"); //col 은 한줄에 몇개씩
		int col = 3;
		if(scol!=null)
			col = Integer.parseInt(scol);
			
		if(col>9) col = 9; //9단까지만 출력할거니깐 9가 넘으면 9로 설정
		
		for(int i=0;i<Math.ceil(9.0/col);i++){ //  9/col 총 몇번 반복하는지 ex) 3이면 한줄에 3개씩 총 2번 반복 남은 하나 출력
															//4면 한줄에 2개씩 2번반복 
			out.print("<table>");
			for(int j=1;j<=9;j++){ // n*1 부터 n*9 까지
				out.print("<tr>");
				int last=i*col+col+2; //아래 for문에서 사용할 변수 -> col이 3일때 2,3,4단 출력 5,6,7단 출력 8,9단 출력
									//i*col+col+2 -> 2를 더하는 이유는 2단부터 출력하기 때문
				if(last>9) last = 10; //9단을 넘어가지 않도록 9단을 넘어가면 변경
				for(int k=i*col+2;k<last;k++){ //
					out.print(String.format("<td>%2d * %2d = %2d</td>",k,j,j*k));
				}
				out.print("</tr>");
				//out.print("<br/>");
			}
			out.print("</table>");
			out.print("<br/>");
		}
		out.close();
		
	}

}
