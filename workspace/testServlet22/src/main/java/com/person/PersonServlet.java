package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
//	public void init() {
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 받기 
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		//응답 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //출력 스트림 생성 
		
		out.println("<html>");
	    out.println("<body style='background: beige; color:green;'>");
	    out.print("<h3>");
	    out.println("<ul style='border: 1px solid khaki; color: " + color+ "'>");
	    out.println("<li> 이 름 : " + name + "</li>");
	    out.println("<br>");
	    
	    if(gender==0)
	    	out.println("<li>성 별 : 남 </li> " );
	    else if(gender==1)
		    out.println("<li>성 별 : 여 </li> " );
	    out.println("<br>");
	    
	    out.println("<li>색 깔 : " + color + "</li>" );
	    out.println("<br>");
	    
	    out.println("<li> 취 미 : ");
	    for(String data : hobby) {
	    	out.println(data + "  ");
	    }
	    out.println("</li>");
	    out.println("<br>");
	    
	    out.println("<li>과 목 : " );
	    for(int i=0;i<subject.length;i++) {
	    	out.println(subject[i]+ " ");
	    }
	    out.println("</li>");
	    out.println("<br>");
	    
	    out.println("</ul>");
	    out.print("</h3>");
	    out.println("</body>");
	    out.println("</html>");
	}

//	public void destroy() {
//		
//	}
	

}
