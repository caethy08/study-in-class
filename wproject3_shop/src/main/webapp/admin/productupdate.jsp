<%@page import="pack.product.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<% 
ProductDto dto = productMgr.getProduct(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<%@ include file="admin_top.jsp" %>
<form action="productproc.jsp?flag=update" method="post" enctype="multipart/form-data"> <%--  flag값(컨트롤러 역할)을 기준으로 설정, 파일을 넘길 떄에는 꼭 enctype를 입력해야한다. --%>
<table>
	<tr>
		<td colspan="2">** 상품 수정 **</td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><input type="text" name="name" value="<%= dto.getName() %>"></td>		
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price" value="<%= dto.getPrice() %>" ></td>		
	</tr>
	<tr>
		<td>설명</td>
		<td><textarea rows="5" style="width: 99%" name="detail"><%= dto.getDetail()%></textarea> </td>		
	</tr>
	<tr>
		<td>재고량</td>
		<td><input type="text" name="stock" value="<%= dto.getStock()%>"></td>		
	</tr>
	<tr>
		<td>이미지</td>
		<td>
		<img alt="" src="../upload/<%= dto.getImage() %>">
		<input type="file" name="image" size="30"> <%-- 복수개를 수정하고 싶다면 ㅡmultiple --%>
		</td>		
	</tr>
	<tr>
		<td colspan="2">
		<br>
		<input type="hidden" name="no" value="<%= dto.getNo() %>">
		<input type="submit" value="상품 수정">
		<input type="reset" value="수정 취소">		
		</td>
	</tr>	
</table>
</form>
<%@ include file="admin_bottom.jsp" %>

</body>
</html>