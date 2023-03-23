package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response); //return 값으로 ~~.jsp파일 값을 내야하니까 String으로 잡는다.
}
