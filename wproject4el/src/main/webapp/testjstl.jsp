<%@page import="pack.Student"%>
<%@page import="pack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전통적 : 안녕 <%=request.getAttribute("irum") %>
<% 
out.println(request.getAttribute("irum"));
%>
<br>
EL: 반가워 ${irum} ${requsetScope.irum}
<br>
전통적 : 
<% Person p = (Person)request.getAttribute("person"); %>
<%=p.getName()%>
<% Student s = (Student)request.getAttribute("student"); %>
<%= s.getAge() %> 
<br>
EL: ${requsetScope.person.name } ${students.age }
<br><br>
동물 : ${animal[0] } ${animal[1] } ${animal["2"] }
<br><br>
<c:if test = "${list != null}">
	<c:forEach var="a" items="${list}">
		<c:forEach var="b" items="${a }">
			${b }
	</c:forEach>
	<br>
	</c:forEach>
</c:if>
<br>
<c:choose>
	<c:when test="${list eq null}">자료없음</c:when>
	<c:otherwise>자료있음</c:otherwise>
</c:choose>

<hr>
예외 처리 <br>
<c:catch var="myErr">
	<% 
	int a = 10/2;
	out.print("a : " +  a);
	%>
</c:catch>
<c:if test="${myErr != null }">
	에러 발생 ; ${myErr.message }
</c:if>
<hr>
계속
<br>다ㅡㄴ 문서 포함 <br>
include 지시어 사용: <%@include file="poham.jsp"%>
<br>
jstl 사용 : <c:import url="poham.jsp"/>
<hr>
<%-- 
<c:import url="https://www.daum.net/"/>
 --%>
 <c:set var="url" value="https://www.naver.com" />
 <c:import url="${url }" var="u" />
 <c:out value="${url }"></c:out>
 <c:out value="${u}" />
</body>
</html>