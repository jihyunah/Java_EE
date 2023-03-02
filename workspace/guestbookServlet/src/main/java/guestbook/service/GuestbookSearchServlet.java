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
      request.setCharacterEncoding("UTF-8");
      
      //1. 데이터
      int seq = Integer.parseInt(request.getParameter("seq"));

      //DB 연동
      GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
      GuestbookDTO guestbookDTO = guestbookDAO.guestbookSearch(seq);
      
      //응답
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      
      out.println("<html>");
      out.println("<body>");
      
      if(guestbookDTO != null) {
         out.println("<table border='1' cellpadding='5' cellspacing='0'");
         
         out.println("<tr>");
         out.println("<td width='150'>작성자</td>");
         out.println("<td width='150'>" + guestbookDTO.getName() + "</td>");
         out.println("<td width='150'>작성일</td>");
         out.println("<td width='150'>" +guestbookDTO.getLogtime() +  "</td>");
         out.println("</tr>");
         
         out.println("<tr>");
         out.println("<td>이메일</td>");
         out.println("<td colspan='3'>" + guestbookDTO.getEmail() + "</td>");
         out.println("</tr>");
         
         out.println("<tr>");
         out.println("<td>홈페이지</td>");
         out.println("<td colspan='3'>" + guestbookDTO.getHomepage() + "</td>");
         out.println("</tr>");
         
         out.println("<tr>");
         out.println("<td>제목</td>");
         out.println("<td colspan='3'>" + guestbookDTO.getSubject() + "</td>");
         out.println("</tr>");
         
         out.println("<tr>");
         out.println("<td colspan='4' height='150'><pre>" + guestbookDTO.getContent() + "</pre></td>");
         out.println("</tr>");
         
         out.println("</table>");
      }else {
         out.println("<h3>글번호가 없습니다.</h3>");
      }
      
      out.println("</body>");
      out.println("</html>");
      
   }

}