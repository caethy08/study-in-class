<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<%@ include file="admin_top.jsp" %>
<form action="productproc.jsp?flag=insert" method="post" enctype="multipart/form-data"> <%--  flag값(컨트롤러 역할)을 기준으로 설정, 파일을 넘길 떄에는 꼭 enctype를 입력해야한다. --%>
<table>
		<tr>
		<td colspan="2">** 상품 ㅅ **</td>
	</tr>
	<tr>
		<td>상품명</td>
		<td><input type="text" name="name"></td>		
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price"></td>		
	</tr>
	<tr>
		<td>설명</td>
		<td><textarea rows="5" style="width: 99%" name="detail"></textarea> </td>		
	</tr>
	<tr>
		<td>재고량</td>
		<td><input type="text" name="stock"></td>		
	</tr>
	<tr>
		<td>이미지</td>
		<td><input type="file" name="image" size="30"></td>		
	</tr>
	<tr>
		<td colspan="2">
		<br>
		<input type="submit" value="상품 등록">
		<input type="reset" value="새로 입력">		
		</td>
	</tr>
</table>
</form>
<%@ include file="admin_bottom.jsp" %>

</body>
</html>