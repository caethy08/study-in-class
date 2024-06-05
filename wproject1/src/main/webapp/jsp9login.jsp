<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String id = request.getParameter("id");
String password = request.getParameter("password");

// Authentication(인증) : 실제로는 DB정보를 읽어 확인
String validId = "ok";
String validpassword = "123";

if(id != null && password != null && id.equalsIgnoreCase(validId) 
		&& password.equals(validpassword)){
	//인증이 유효하면 세선 생성
	HttpSession ses = request.getSession();
	ses.setAttribute("userId", id); // 세션 생성 후 session Id를 클라이언트 컴퓨터의 쿠키에 저장
	
	System.out.println("1");
	//성공한 경우 보여줄 페이지
	response.sendRedirect("jsp9success.jsp");  //success.html
	System.out.println("2");
}else{
	//실패한 경우 처리 작업
	out.println("<html><body>");
	out.println("<h3>로그인 실패</h3>");
	out.println("<a href= 'jsp9sessionlogin.html'>다시 시도</a>");
	out.println("</body></okhtml>");
	
}
%>