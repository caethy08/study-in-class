<%@page import="pack.member.ZipcodeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<% 
request.setCharacterEncoding("utf-8");
String check = request.getParameter("check"); //y(동이름 입력하면 출력)또는 n의 값을 가지는 check
String dongName = request.getParameter("dongName");

ArrayList<ZipcodeDto> zlist = memberMgr.zipcodeRead(dongName);  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.onload = () => {
	document.querySelector("#btnZipFind").onclick = dongCheck;
	document.querySelector("#btnZipClose").onclick = function() {
		window.close();
	};
}

function dongCheck() {
	if(zipform.dongName.value === ""){
		alert("검색할 동이름을 입력하세요");
		zipform.dongName.focus();
		return;
	}
	zipform.submit();
}

function sendFnc(zipcode, a1, a2, a3, a4) {
	//alert(zipcode + a1 + a2 + a3 + a4);
	opener.document.regForm.zipcode.value = zipcode;
	const addr = a1 + " " + a2 + " " + a3 + " " + a4; //상세 주소를 묶음
	opener.document.regForm.address.value = addr; //묶은 addr을 주소 페이지에 넣음
	
	window.close();  //주소 검색창 닫기
}
</script>
</head>
<body>
<strong>*** 우편자료 찾기 ***</strong>
<form action="zipcheck.jsp" name="zipform" method="get">
<table>
	<tr>
		<td>
		동 이름 입력 : <input type="text" name="dongName" size="30">
		<input type="button" value="검색" id="btnZipFind">
		<input type="button" value="닫기" id="btnZipClose">
		<input type="hidden" name="check" value="n">
		</td>
	</tr>
</table>
</form>
<% 
if(check.equals("n")){ //검색을 시도한 경우
	if(zlist.isEmpty()){
%>		
	<b> 겸색 결과가 없습니다 </b>
<% 
	}else{
%>
	<table>
		<tr>
			<td style="text-align: center;">
			검색 자료를 클릭하면 자동으로 주소가 입력됩니다.
			</td>
		</tr>
		<tr>
			<td>
			<% 
			for(int i=0; i < zlist.size(); i++){
				ZipcodeDto dto = (ZipcodeDto)zlist.get(i);
				String zipcode = dto.getZipcode();
				String area1 = dto.getArea1();
				String area2 = dto.getArea2();
				String area3 = dto.getArea3();
				String area4 = dto.getArea4();
				if(area4 == null) area4 = "";
			%>
			<a href="javascript:sendFnc('<%= zipcode %>', '<%= area1 %>', '<%= area2 %>', '<%= area3 %>', '<%= area4 %>')">
			<%= zipcode %> <%= area1 %><%= area2 %><%= area3 %><%= area4 %>
			</a>
			<br>
			<% 
			}
			%>				
			</td>
		</tr>
	</table>
<% 
	}
}
%>		


</body>
</html>