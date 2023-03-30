package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//동적처리 할 것이기 때문에 DB 안가도 된다. 
//		BoardDAO boardDAO = BoardDAO.getInstance();
//		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		
		//응답 
		request.setAttribute("seq", seq); //boardList.js에서 받은걸 boardView로 넘겨주기 위해. 
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardView.jsp");
		
		return "/index.jsp";
	}

}
