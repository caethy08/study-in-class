<%@page import="pack.product.ProductDto"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h2>*주문 상품 목록*</h2>
<%@ include file="guest_top.jsp" %>
<table>
	<tr style="background-color: black; color: white;">
		<th>주문 번호</th><th>상품명</th><th>주문 수</th><th>주문 일</th><th>주문 상태</th>		
	</tr>
<% 
String id = (String)session.getAttribute("idkey");

ArrayList<OrderBean> list = orderMgr.getOrder(id);

if(list.isEmpty()){
%>
	<tr>
		<td colspan="5"><%=id %>님, 주문한 상품이 없습니다.</td>
	</tr>
<% 
}else{
	for(OrderBean ord:list){
		ProductDto productdto = productMgr.getProduct(ord.getProduct_no());
%>
	<tr>
		<td><%=ord.getNo() %></td>
		<td><%=productdto.getName() %></td>
		<td><%=ord.getQuantity() %></td>
		<td><%=ord.getSdate() %></td>
		<!-- 
		<td><%=ord.getState() %></td>
		-->
		 
		<!-- //1:접수중 2: 입금확인, 3: 배송준비, 4: 배송중, 5: 주문확정 -->
		<td>
		<% 
		switch(ord.getState()){
		case "1" : out.println("접수중"); break;
		case "2" : out.println("입금확인"); break;
		case "3" : out.println("배송준비"); break;
		case "4" : out.println("배송중"); break;
		case "5" : out.println("주문확정"); break;
		default: out.println("접수중");
		}
		%>
		</td>
	</tr>	
<% 
	}
}
%>		
</table>
<%@ include file="guest_bottom.jsp" %>
</body>
</html>