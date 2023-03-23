package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class WriteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {//Servlet의 request, response다. 
		request.setAttribute("display", "/member/writeForm.jsp"); //display라는 키 값에 writeForm.jsp를 넣어라. 
		return "/index.jsp";
	}

}
