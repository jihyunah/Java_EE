package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    
    public GuestbookListServlet() {
        super();
       
    }

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //데이터 X
      int pg = Integer.parseInt(request.getParameter("pg"));
      
      //페이징 처리 - 1페이지당 2개씩
      /*
               stardNum   endNum
       PG=1   RN>=1 AND RN <=2
       PG=2   RN>=3 AND RN <=4
       PG=3   RN>=5 AND RN <=6 
       
       
       */
      int endNum = pg*2;
      int startNum = endNum-1;
      
      
      //DB 연동
      GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
       ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum);
      
       //총 글수
      int totalA = guestbookDAO.getTotalA();
      System.out.println(totalA);
       
      //총 페이지수
      
      /*
       총글수 : 7
       총페이지수 : 4
       
       총글수 : 8
       총페이지수 : 4
       
       */
      
      int totalP = ( totalA + 1 ) / 2;
      
      //응답
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<body>");
      out.println("<style>");
      out.println("#currentPagingDiv {float: left; border: 1px red solid; color: red; width: 20px; height: 20px; margin-left: 5px; text-align:center;}");
      out.println("#pagingDiv {float: left; border: 1px black solid; color: black; width: 20px; height: 20px; margin-left: 5px; text-align:center;}");
      out.println("#currentPaging {color: red; text-decoration: none;}");
      out.println("#paging { color: black; text-decoration: none;}");
      out.println("</style>");
      
      for(int i = 1; i <= totalP; i++) {
    	  if(i==pg)
    		  out.println("<div id='currentPagingDiv'><a id='currentPaging' href='/guestbookServlet/GuestbookListServlet?pg=" + i +"'>" + i + "</a></div>");
    	  else
    	  out.println("<div id='pagingDiv'><a id='paging' href='/guestbookServlet/GuestbookListServlet?pg=" + i +"'>" + i + "</a></div>");
      }
      out.println("<br><br>");
      
      if(list != null) {
         for(GuestbookDTO guestbookDTO : list) {
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
            out.println("<hr style='border-color: red; width: 700px; margin:10px 0;'>");   //margin은 시계방향
         }//for
      }//if
      
         
      out.println("</body>");
      out.println("</html>");
   }

}