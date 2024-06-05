<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//세션 읽기
HttpSession ses = request.getSession(false);

if(ses != null && ses.getAttribute("userId") !=null){
	String userid = (String)ses.getAttribute("userId");
	
	System.out.println("3");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공페이지</h2>
<p>환영합니다 <%= userid%>를 사용하시는 분 </p>
인증에 성공한 경우 처리할 뭔가를 작업 Authorization(인가)
<br>
<a href="jsp9logout.jsp">로그아웃</a>

</body>
</html>
<% 
}else{
	//로그인 없이 호출된 경우
	response.sendRedirect("jsp9sessionlogin.html");//
	System.out.println("4");
}
%>