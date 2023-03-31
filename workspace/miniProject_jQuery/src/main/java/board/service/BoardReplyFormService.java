package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
			//데이터 
			int seq = Integer.parseInt(request.getParameter("seq")); //원글 번호 
			int pg = Integer.parseInt(request.getParameter("pg")); //원글이 있는 페이지 번호 
						
			//응답 
			request.setAttribute("seq", seq); //boardList.js에서 받은걸 boardView로 넘겨주기 위해. 
			request.setAttribute("pg", pg);
			request.setAttribute("display", "/board/boardReplyForm.jsp");
				
			return "/index.jsp";
	}

}
