package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		
		//데이터 
		String subject = request.getParameter("subject"); //boardWriteForm에서 받아옴. 
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
		
		//값 꺼낼땐 map.get("id");
		
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		
		//응답 
		return "/index.jsp";
	}

}
