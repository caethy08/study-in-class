$(document).ready(function(){
	//html 문서를 text로 읽기
	$('#test1').click(function(){
		//alert("a");
		$("#disp").empty(); //출력장소를 깨끗이 비우고 출력
		
		
		$("#disp").load("jq4.html"); //비동기 방식
		$("#disp").hide().load("jq4.html", function(){
			$(this).fadeIn(); //effect 처리: 속도는 떨어지고 자원의 낭비가 약간 일어난다
		}); 
	});
	
	//json 읽기
	$('#test2').click(function(){
		$("#disp").empty();
		$.getJSON('jq4json.jsp', function(datas){
			//alert(datas);
			//$("#disp").text(datas);
			let items = [];
			let str = "<ul>";
			$.each(datas.sangpums, function(index, data){//jquery의 반복문 each
				console.log(data);
				//alert(index + " " + data);
				let s = "<li>" + data["code"] + " " + data["sang"] + " " 
							+ data["su"] + " " + data["dan"] + "</li>";
				
				items.push(s);
			});
			str += items.join('') + "</ul>"
			//배열의 모든 항목을 하나의 문자열로 결합
			
			$("#disp").html(str);
		});
	});
	
	//xml읽기
	$('#test3').click(function(){
		//alert("3");
		$.get('jq4xml.jsp', function(datas){
		//$.post('jq4xml.jsp', function(datas){	
			//alert(datas);
			//alert($(datas).find('sangpum').length);// 하위 element(요소)를 검색할때 find()
			$("#disp").empty();
			
			$(datas).find('sangpum').each(function(){
				let sangpum = $(this);
				let str = "<div>";
				str += sangpum.find('code').text() + " ";
				str += sangpum.find('sangirum').text() + " ";
				str += sangpum.find('su').text() + " ";
				str += sangpum.find('danga').text() + " ";
				str += "</div>";
				$("#disp").append(str);
			});
		}).fail(function(){
			$("#disp").text('test3 처리 오류');
		});
	});
	
	//json 읽기2
	$('#test4').click(function(){
		//alert('4');
		$("#disp").empty();
		
		$.ajax({
			type:"get",   //요청 방식 post
			url:'jq4json.jsp',
			//data:{'code':3, 'sang':'book'},  //jq4json.jsp?code=3&sang=book  > code라는 변수에 3을 담아감
			dataType:"json",    //반환 data type
			success:function(datas){
				//alert(datas);
				let str = "";
				let count = 0;
				str += "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th><tr>";
				
				$.each(datas.sangpums, function(idx, data){ //$=jquery 가능
					str += "<tr>";
					str += "<td>" + data["code"] + "</td>";
					str += "<td>" + data["sang"] + "</td>";
					str += "<td>" + data["su"] + "</td>";
					str += "<td>" + data["dan"] + "</td>";
					//str += "<td>" + data.dan + "</td>";
					str += "</tr>";
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`건수 : ${count}개`); //자바스크립트의 string	
			},
			error:function(){
				$("#disp").text('test4 처리 오류');
			}
			
		});
	});
	
	//xml 읽기2
	$('#test5').on("click",function(){
		//alert('5');
		$("#disp").empty();
		
		$.ajax({
			type:"post",  
			url:'jq4xml.jsp',
			dataType:"xml",    //반환 data type
			success:function(datas){
				//alert(datas);
				let count = 0;
				let str = "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th><tr>";
				
				$(datas).find('sangpum').each(function(){
					str += "<tr>";
					str += "<td>" + $(this).find("code").text() + "</td>";
					str += "<td>" + $(this).find("sangirum").text() + "</td>";
					str += "<td>" + $(this).find("su").text() + "</td>";
					str += "<td>" + $(this).find("danga").text() + "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`건수(xml) : ${count}개`); //자바스크립트의 string	
			},
			error:function(){
				$("#disp").text('test4 처리 오류');
			}
			
		});
	});
});