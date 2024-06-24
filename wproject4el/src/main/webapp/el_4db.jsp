<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="connClass" class="pack.ConnClass" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 정보(Beans : 전통적 방법으로 출력)</h2>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<% 
	ArrayList<SangpumDto> list = connClass.getDataAll();
	for(SangpumDto s:list){
	%>
		<tr>
			<td><%= s.getCode() %></td>
			<td><%= s.getSang() %></td>
			<td><%= s.getSu() %></td>
			<td><%= s.getDan() %></td>
		</tr>
	<% 
	}
	%>		
</table>
<br>
<h2>상품 정보(Beans : EL, Jstl로 출력)</h2>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList<SangpumDto> list2 = connClass.getDataAll(); %>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="s" items="<%=list2 %>">
	<tr>
		<%-- <td>${s.code}</td>는  <td><%= s.getCode() %></td>와 같은 의미--%>
		<td>${s.code}</td>
		<td>${s.sang}</td>
		<td>${s.su}</td>
		<td>${s.dan}</td>	
	</tr>
	</c:forEach>
</table>
</body>
</html>