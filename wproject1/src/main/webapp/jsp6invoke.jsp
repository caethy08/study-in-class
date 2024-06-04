<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//현재 jsp 파일은 비즈니스 로직 처리용으로 출력에는 참여하지 않음
String data = request.getParameter("data"); //servlet에서 받을 때와 동일
String msg = "Mr. " + data;

//1. redirect 방식으로 파일 호출
//response.sendRedirect("jsp6invoked.jsp?data=" + msg);
//response.sendRedirect("jsp6invoked.jsp?data=" + msg + "&data2=" + msg2); //여러개의 데이터를 주고싶을 때


//2. forward 방식으로 파일 호출
request.setAttribute("datas", msg); //request는 컨테이너 기능을 가지고 있어서 이름과 값을 담을 수 있다.

ArrayList<String> list = new ArrayList<String>();
list.add("mouse");
list.add("pen");
list.add("book");
request.setAttribute("product", list);


//request.getRequestDispatcher("jsp6invoked.jsp").forward(request, response); //반드시 request, response를 넘겨줘야 한다 아니면 에러

%>
<jsp:forward page="jsp6invoked.jsp"></jsp:forward> //jsp액션태그를 이용해 윗줄을 줄여씀