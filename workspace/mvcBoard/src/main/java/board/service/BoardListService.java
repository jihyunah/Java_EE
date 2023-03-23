package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {
	

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 세션
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		
		// DB - 1페이지당 5개씩 
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		//1페이지당 5개씩 
		
		/*
		pg=1 rn>=1 and rn<=5
		pg=2 rn>=6 and rn<=10
		pg=3 rn>=11 and rn<=15
		*/
		int endNum = pg*5;
		int startNum = endNum-4;
		
		
		
		Map<String, Integer>map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardDAO.boardList(map);
		
		
		//페이징 처리
		int totalA = boardDAO.getTotalA();//총글수
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
				
		boardPaging.makePagingHTML();
		
		// 응답 
		request.setAttribute("pg", pg);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("list", list);
		return "/board/boardList.jsp";
		
		
		
		
	}

}
