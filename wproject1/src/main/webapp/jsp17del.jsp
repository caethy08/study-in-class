<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String code = request.getParameter("code"); %>
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page"/>

<% 
//boolean b = connP.updateDataOk(bean);
//if(b)...
if(connP.deleteData(code))
	response.sendRedirect("jsp17dbcp.jsp");  //삭제 후 상품보기로 이동
else
	response.sendRedirect("jsp17fail.html");
%>