<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//불려다니는 파일: 함꼐 사용
String adminId = (String)session.getAttribute("adminOk");
 //boardcontent에서 설정해 둔 관리자 아이디, 비번 사용

 if(adminId == null){ //adminid를 읽을 때
	 response.sendRedirect("adminlogin.jsp");
 	//return;
 }
%>
<table>
  <tr style="background-color: yellow; text-align: center;">
    <td><a href="../guest/guest_index.jsp">홈페이지</a></td>
    <td><a href="adminlogout.jsp">로그아웃</a></td>
    <td><a href="membermanager.jsp">회원관리</a></td>
    <td><a href="productmanager.jsp">상품관리</a></td>
    <td><a href="ordermanager.jsp">주문관리</a></td>
  </tr>
</table>
