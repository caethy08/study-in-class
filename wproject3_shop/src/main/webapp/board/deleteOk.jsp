<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--   한가지만 받아오면 됨
<jsp:useBean id="bean" class="pack.board.BoardFormBean"/>
<jsp:setProperty property="*" name="bean"/>
 --%>  
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>

<% 
String spage = request.getParameter("page");
String num = request.getParameter("num");
String pass = request.getParameter("pass");

boolean b = boardMgr.checkPass(Integer.parseInt(num), pass); //비번 비교

if(b){
	boardMgr.delData(num);
	response.sendRedirect("boardlist.jsp?page=" + spage); //삭제 후 이동
}else{
%>
	<script >
		alert("비밀번호 불일치");
		history.back();
	</script>	
<% 
}
%>