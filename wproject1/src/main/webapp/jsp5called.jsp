<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에 의해 호출(Servlet이 호출)된 파일 <br>
<% 
//redirect 방식
String mydata = request.getParameter("data"); //쿼리 스트링
out.println("전송된 data(redirect)는" + mydata);
out.println("<hr>");
//forward방식
String ourdata = (String)request.getAttribute("datas"); //setattribute로 밀어서 getattibute로 받음
out.println("전송된 data(forward)는" + ourdata);
%>
</body>
</html>