package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터 
		int pseq = Integer.parseInt(request.getParameter("seq")); //원글번호 pseq
		int pg = Integer.parseInt(request.getParameter("pg")); //얘는 DB 안감.
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");			
		
		//세션 
		HttpSession session = request.getSession();  
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		
		//위 5개 데이터 묶음처리 -> Map 사용하기 
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id); //"id"가 이름, id가 값. 
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		map.put("pseq", pseq + ""); //원글번호
				
		//값 꺼낼땐 map.get("id");
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.boardReply(map);
		
		//응답 
		request.setAttribute("pseq", pseq); //boardList.js에서 받은걸 boardView로 넘겨주기 위해. 
		request.setAttribute("pg", pg);
		request.setAttribute("subject", subject);
		request.setAttribute("content", content);
		request.setAttribute("display", "/board/boardReply.jsp");
		
		return "/board/boardReply.jsp";
				
	}

}
