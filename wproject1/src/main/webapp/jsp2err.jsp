<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 jsp문서는 예기치 않은 에러가 발생한 경우 대처용(그래서 isErrorPage="true")
<br>
죄송합니다 에러입니다
<br>
<%= "에러 원인은" + exception.getMessage() %> <!-- exception 내장 객체 중 하나 -->
</body>
</html>