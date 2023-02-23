package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void init() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받기 
		int x = Integer.parseInt(request.getParameter("x"));
		int y= Integer.parseInt(request.getParameter("y"));
		
		//응답 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();//출력 
		
		out.println("<html>");
		out.println("<body style='background-color:skyblue'>");
		out.println("<h3>");
		out.println( x + " + " + y + " = " + (x+y) + "<br>");
		out.println( x + " - " + y + " = " + (x-y) + "<br>");
		out.println( x + " * " + y + " = " + (x*y) + "<br>");
		out.println( x + " / " + y + " = " + (x/y) + "<br>");
		out.println("</h3>");
		out.println("<input type='button' value='뒤로' onclick='javascript:history.go(-1)'>"); //1페이지만 뒤로가라.값초기화 안됨. 그대로 남아있음. 
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/testServlet/calc/input.html'>"); //javascript 안써도 onclick은 스크립으로 가기에 생략 가능. 
		out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/testServlet/param.html'>");
		out.println("</body>");
		out.println("</html>");
	}

	public void destroy() {
		
	}

}
