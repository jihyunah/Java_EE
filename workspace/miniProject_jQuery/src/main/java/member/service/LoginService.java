package member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//데이터 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB접속
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);

		MemberDTO memberDTO = memberDAO.memberLogin(map);
		
		//응답
		if(memberDTO == null) {
			return "/member/loginFail.jsp";
		}else {
			HttpSession session = request.getSession(); // 세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memPwd", memberDTO.getPwd());
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			return "/member/loginOk.jsp";
		}

	}

}
