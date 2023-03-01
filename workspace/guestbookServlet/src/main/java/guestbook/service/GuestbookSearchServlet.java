package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//post인 경우 해줘야함. 
		
		// 데이터 
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setSeq(seq);

		//DB 
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		GuestbookDTO selectList = guestbookDAO.guestbookSearch(guestbookDTO);//데이터를 가져간다. 
		
		//응답 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(selectList.getSubject().length()==0) {
			out.println("<h3> 글이 존재하지 않습니다. </h3>");
			out.println("<input type='button' value='뒤로' onclick='history.go(-1)'");
			
		}//if
		else {
			out.println("<form name='guestbookSearchForm'>");
			 out.println("<table border='1' cellpadding='5' cellspacing='0'>");
			  out.println("<th>작성자 </th>");
			  out.println("<td>");
			  	 out.println("<input type='text' name='name' id='name' value='" + selectList.getName() +  "' >");
			  	out.println("<th>작성일</th>" ) ;
			  	out.println("<td>");
			  	 out.println("<input type='text' name='logTime' id='logTime' value='" + selectList.getLogtime() +  "' >");
			  	out.println("</td>");
			  out.println("</tr>");
			  
			  out.println("<tr>");
			  	out.println("<th>이메일</th>");
			  	out.println("<td colspan='3'>");
			  	out.println("<input type='text' name='email' id='email' size='30' value='" + selectList.getEmail() +  "' >");
			  	out.println("</td>");
			  out.println("</tr>");
			  
			  out.println("<tr>");
			  out.println("<th>홈페이지</th>");
			  	out.println("<td colspan='3'>");
			  	out.println("<input type='text' name='homepage' id='homepage' size='40' value='" + selectList.getHomepage() +  "' >");
			  	out.println("</td>");
			  out.println("</tr>");
			  
			  out.println("<tr>");
			  out.println("<th>제목</th>");
			  	out.println("<td colspan='3'>");
			  	out.println("<input type='text' name='subject' id='subject' size='40' value='" + selectList.getSubject() +  "' >");
			  	
			  	out.println("</td>");
			  out.println("</tr>");
			  
			  out.println("<tr>");
			  out.println("<th>내용</th>");
			  	out.println("<td colspan='3'>");
			  	out.println("<textarea name='content' id='content'  rows='15' cols='50' >"+  selectList.getContent() + "</textarea>");
			    out.println("</td>");	
			    out.println("</tr>");
				  
				
				 out.println("</table>");
				out.println("</form>");

				out.println("<input type='button' value='목록' onclick=location.href='http://localhost:8080/guestbook/guestbookSearch.html'");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
