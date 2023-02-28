package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//데이터 
		String id= request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //기존에 만들어진 db 주소를 가져오겠다.
		String name= memberDAO.memberLogin(id,pwd);
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html");
		out.println("<body>");
		if(name==null) {
			out.println("<h3>아이디 또는 비밀번호가 맞지 않습니다.</h3>");
			
		}else {
			out.println("<h3>" + name + "님 로그인</h3>");
		}
		
		
		out.println("</body>");
	    out.println("</html>");
		
		
		
	}

}
