package com.hello;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


///@WebServlet(name = "HelloServlet.java", urlPatterns = { "/HelloServlet.java" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init() {
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("doGet()");
	      
	      response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out= response.getWriter();//생성 
	      out.println("<html>");
	      out.println("<body>");
	      out.println("HELLO SERVLET!<br>");
	      out.println("안녕하세요 서블릿!");
	      out.println("</body>");
	      out.println("</html>");
	  }


	public void destroy(){
		System.out.println("destroy");
	}

}
