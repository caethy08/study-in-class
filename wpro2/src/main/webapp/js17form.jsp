<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바 영역
request.setCharacterEncoding("utf-8");

String irum = request.getParameter("name");
String id = request.getParameter("id");
//수신된 자료를 사바에서 표준 출력장치로 출력
System.out.println(irum + " " + id);

String email = request.getParameter("email");
String nai = request.getParameter("age");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//자바스크립트
console.log(`자바스크립트 표준 출력장치로 출력<%=irum%>`) 
</script>
</head>
<body>
<!-- html -->
이름은 <%=irum %>  아이디는 <%=id %> 이메일은 <%=email %> 나이는 <%=nai %>
</body>
</html>