<%@page import="pack.product.ProductMgr"%>
<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<% 
String no = request.getParameter("no");
ProductDto dto = productMgr.getProduct(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
** 상품 상세 보기 <p/>
** 전체 상품목록(관리자) <p/>
<%@ include file="admin_top.jsp" %>

<table>
	<tr>
		<td style="width: 20%">
			<img alt="" src="../upload/<%=dto.getImage() %>" width="150"/>
		</td>
		<td>
			<table style="width: 100%">
			<tr>
				<td>번호 : 	</td><td><%=dto.getNo()%></td>
			</tr>
			<tr>
				<td>상품명 : 	</td><td><%=dto.getName()%></td>
			</tr>
			<tr>
				<td>가격 : 	</td><td><%=dto.getPrice()%></td>
			</tr>
			<tr>
				<td>등록일 : 	</td><td><%=dto.getSdate()%></td>
			</tr>
			<tr>
				<td>재고량 : 	</td><td><%=dto.getStock()%></td>
			</tr>
			</table>
		</td>
		<td style="width: 30%">
			<b>*상품 설명*</b>
			<br>
			<%= dto.getDetail() %>
		
		</td>
	</tr>
	<tr>
		<td colspan="3" style="text-align: center;">
			<a href="javascript:productUpdate('<%=dto.getNo()%>')">수정하기</a> <%-- 번호를 들고 가야한다 --%>
			<a href="javascript:productDelete('<%=dto.getNo()%>')">삭제하기</a>
		</td>
	</tr>
</table>
<%@ include file="admin_bottom.jsp" %>

<form action="productupdate.jsp" name = "updateForm" method="post">
	<input type="hidden" name="no"> <%--//hidden no를 들고 productdetail.jsp로 이동  --%>
</form>

<form action="productproc.jsp?flag=delete" name = "delForm" method="post"> 
	<input type="hidden" name="no"> <%--//hidden no를 들고 productdetail.jsp로 이동 get메소드의 경우 no만 이동하고 flag가 이동 x  --%>
</form>
</body>
</html>