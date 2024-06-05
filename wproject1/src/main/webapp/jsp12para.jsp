<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String mbc = request.getParameter("msg");
%>

<jsp:useBean id="my" class="pack.Para1Class"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Beans 연습: 빈즈에 값 전달</b>
<% 
//우리가 현재까지 알고 있는 기술 사용
my.setMsg(mbc);
out.println("<br>메세지 출력 : " + my.getMsg());
%>
<br>
<!-- String mbc = request.getParameter("msg"); 내부적으로 자동적으로 처리된다.단, 파라미터의 이름과 setproperty와 클래스의 멤버필드의 임름과 같아야 한다. -->
<jsp:setProperty property="msg" name="my"/> <!-- name자리에는 para1class의 set msg를 부른다 setter 호출-->
<br>메세지 출력(action tag 사용) : 
<jsp:getProperty property="msg" name="my"/> <!-- getter 호출 -->
</body>
</html>