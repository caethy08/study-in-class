let xhr
let checkFirst = loopSend = false;
let kbs;

function sijak(){
	if(checkFirst === false){
		kbs = setTimeout("sendkeyword()", 800); //1초 후에 "sendkeyword"를 보냄
		loopSend = true;
	}
}

function sendkeyword(){
	//console.log("a");
	
	//let keyword = document.querySelector("#kbs").value;
	let keyword = document.frm.keyword.value;
	//console.log(keyword);
	
	if(keyword === ""){
		hide();
	}else{
		xhr = new XMLHttpRequest();
		let para = "keyword=" + keyword;
	xhr.open("post", "jq8.jsp?" + para, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
				process();
			}
		}
	xhr.send(null);
	}
	clearTimeout(kbs);
}

function process(){
	let resultData = xhr.responseText;
	//console.log(resultData);
	let result = resultData.split("|");
	//console.log(`건수:${result[0]} 자료:${result[1]}`);
	let tot = result[0];
	if(tot > 0){
		let datas = result[1].split(",");
		let imsi = "";
		for(let i=0; i < datas.length; i++){
			imsi += "<a href=\"javascript:func('" + datas[i] + "')\">" + datas[i] + "</a><br>"
		}
		console.log(imsi);
		document.querySelector("#suggestList").innerHTML = imsi;
		show();
	}
}

function func(reData){
	//alert(reData);
	frm.sel.value = reData;
	loopSend = checkFirst = false;
	hide();
	
	frm.keyword.value = "";
}

function hide(){
	document.querySelector("#suggest").style.display="none";
}

function show(){
	document.querySelector("#suggest").style.display="";
}