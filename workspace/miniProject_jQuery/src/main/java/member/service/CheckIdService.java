package member.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String id = request.getParameter("id");	

		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean existId = memberDAO.isExistId(id); // 아이디가 있다-true-사용 불가능

		// 응답
		request.setAttribute("id", id);
		if (existId) {
			// 아이디가 이미 존재하는 경우
			request.setAttribute("resultMsg", "이미 존재하는 아이디입니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/checkIdFail.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			// 아이디가 존재하지 않는 경우
			request.setAttribute("resultMsg", "사용 가능한 아이디입니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/checkIdOk.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	}
}
