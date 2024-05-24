<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String irum = request.getParameter("name");
String nai = request.getParameter("age");
%>    
 <%-- jsp가 내용을 받아서 클라이언트에게 뿌림  --%>
<%=irum + "님의 나이는 " + nai + "살" %>
