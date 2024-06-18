<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>  <%-- cart는 렘상에서만 존재하므로 세션이 살아있는 동안 살아있도록 scope:session주기 --%>
<jsp:useBean id="order" class="pack.order.OrderBean" />
<jsp:setProperty property="*" name="order"/>

<% 
String orderFlag = request.getParameter("flag"); //구매목록 보기, 수장, 삭제 판단용
String id = (String)session.getAttribute("idkey");

//out.print(order.getProduct_no() + ", 주문수량" + order.getQuantity());

if(id == null){
	response.sendRedirect("../member/login.jsp");  //회원 로그인을 안하면 로그인 창으로 이동
}else{
	if(orderFlag == null){
		//cart에 주문 상품 담기
		order.setId(id);  //order에는 id와 quantitiy와 product_no가 있음
		cartMgr.addCart(order);
%>
		<script>
		alert("장바구니에 담았습니다");
		location.href = "cartlist.jsp"; //카트에 등록된 주문 상품 목록 보기
		</script>
<%
	}else if(orderFlag.equals("update")){ //자바에서 문자열을 비교할때는 .equals사용, null비교시에만 사용
		order.setId(id);
		cartMgr.updateCart(order); 
%>
	<script>
	alert("장바구니의 내용을 수정했습니다");
	location.href="cartlist.jsp"; //카트에 등록돤 주문 상품 목록 보기
	</script>
<%
	}else if(orderFlag.equals("del")){
		cartMgr.deleteCart(order);
%>
	<script>
	alert("해당 상품의 주문을 삭제했습니다");
	location.href="cartlist.jsp";
	</script>
<% 
	}
}
%>	  