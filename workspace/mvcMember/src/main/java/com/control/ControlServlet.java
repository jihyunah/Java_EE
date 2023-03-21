package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = {"*.do"},
		initParams = {
				@WebInitParam(name="propertyConfig", value="command.properties")
		}
		
)

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
       
	//init은 web.xml 을 한번만 읽어오기 때문에 사용한다. 
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); //Get이나 Post나 하는 일이 같기에, 둘다 execute 함수로 가라고 설정.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); //execute 는 interface 부모의 추상메소드.
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		//한글처리 (get과 post 방식의 차이. post일 때 따로 처리를 해줘야함. )
		if (request.getMethod().equals("POST"))  { //메소드의 종류 이름을 얻어와라. ex) post or get
			request.setCharacterEncoding("UTF-8"); //post방식이라면 나를 한글처리 해주세요.
		}
		
		//요청이 들어왔을 때 => http://localhost:8080/mvcmember/member/writeForm.do
	    String category = request.getServletPath();
	    System.out.println("category = "+category); // 결과가 /member/writeForm.do
	      
	    CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
	    String view = null;
	      
	    try {
	        view = com.requestPro(request, response); // "/member/writeForm.jsp"
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
	      
	    //forward
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
	    dispatcher.forward(request, response);//제어권 넘기기
		
	}

}
