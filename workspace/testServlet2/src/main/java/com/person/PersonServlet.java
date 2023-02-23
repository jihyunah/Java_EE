package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	public void init() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받기 
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String subject = request.getParameter("subject");
		
		//응답 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //출력 스트림 생성 
		
		out.println("<html>");
	    out.println("<body>");
	    out.println("<ul>");
	    out.println("<li> 이름 : " + name + "</li>");
	    
	    if(gender==0)
	    	out.println("<li>성별 : 남 </li> " );
	    else if(gender==1)
		    out.println("<li>성별 : 여 </li> " );
	    
	    out.println("<li>색깔 : " + color + "</li>" );
		
	    for(String data : hobby) {
	    	out.println("<li> 취미 : " + data + "</li>" );
	    }
	    
	    out.println("<li>과목 : " + subject + "</li>");
		
	    
	    out.println("</ul>");
	    out.println("</body>");
	    out.println("</html>");
	}

	public void destroy() {
		
	}
	

}
