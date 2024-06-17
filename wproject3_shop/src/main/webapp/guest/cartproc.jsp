<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>  <%-- cart는 렘상에서만 존재하므로 세션이 살아있는 동안 살아있도록 scope:session주기 --%>
<jsp:useBean id="order" class="pack.order.OrderBean" />
<jsp:setProperty property="*" name="order"/>

<% 
String orderFlag = request.getParameter("flag"); //구매목록 보기, 수장, 삭제 판단용
String id = (String)session.getAttribute("idkey");

out.print(order.getProduct_no() + ", 주문수량" + order.getQuantity());
%>	  