<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="bean" class="pack.SangpumBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="connP" class="pack.ConnPooling" />

<% 
boolean b = connP.insertData(bean); //추가 하기 위해서 SangpumBean이 가진 입력값을 가지고 간다

if(b)
	response.sendRedirect("jsp17dbcp.jsp");  //추가 후 상품 보기
else
	response.sendRedirect("jsp17fail.jsp");
%>