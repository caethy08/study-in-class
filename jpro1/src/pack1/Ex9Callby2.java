package pack1;

public class Ex9Callby2 {
	public void ex(int a, int b) { //매개변수로 기본형을 사용 //a와 b의 기억장소의 값을 맞바꾸는 것
		int imsi = a; //imsi 잠시 a값을 보관
		a = b; // b의 값을 a에게 줌
		b = imsi;  //b에게 imsi에 보관된 a값을 전달
		System.out.println("매소드 내의 a:" + a + ", b:" + b);
	}
	
	public void ex(Ex9Callby1 data) {//매개변수로 참조형 사용  타입이ex9이어서 class에 접근 가능
		int imsi = data.a;  //객체의 주소를 넘겨서 그걸 이용해 객체를 찾아낸다
		data.a = data.b;
		data.b = imsi;
		System.out.println("매소드(참조형) 내의 a:" + data.a + ",b:" + data.b);
		
	}
	public void ex(int[] ar) {
		int imsi = ar[0];
		ar[0] = ar[1];
		ar[1] = imsi;
		System.out.println("메소드 내의 배열요소[0]:" + ar[0] + ", [1]:" + ar[1]);
	}
}
