/**
 js 별도 작성
 */

 let i = 0, tot = 0;
 do{
	i++;
	tot += i;
}while(i < 10);

document.write(`<br>합은 ${tot} `);
//js 파일은 단독으로는 거의 사용되지 않는다. node에서는 가능