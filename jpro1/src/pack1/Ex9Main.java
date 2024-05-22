package pack1;

public class Ex9Main {

	public static void main(String[] args) {
		// 메소드 호출 시 매개변수를 통한 자료 전달(타입이 기본형, 참조형)
		Ex9Callby1 myData = new Ex9Callby1();
		Ex9Callby2 myMethod = new Ex9Callby2();
		
		System.out.println("원래 a:" + myData.a + ",b:" + myData.b);
		myMethod.ex(myData.a, myData.b); //인수로 기본형 전달(값이 전달) 
		System.out.println("1. 수행 후 a:" + myData.a + ",b:" + myData.b);
	
		System.out.println();
		myMethod.ex(myData); //ex9callby1 객체 타입의 주소 전달
		System.out.println("2. 수행 후 a:" + myData.a + ",b:" + myData.b);

		System.out.println();
		System.out.println("배열의 대표명 c : " + myData.c); //배열의 주소
		//int kbs[] = myData.c; //주소 치환 c의 주소를 kbs에게 넘김(같은배열이어서 가능)
		//System.out.println(myData.c[0]);
		//System.out.println(kbs[0]);
		myMethod.ex(myData.c); 
		System.out.println(myData.c[0]);
		System.out.println("3. 수행 후 c[0]:" + myData.c[0] + ",c[1]:" + myData.c[1]);

		

	}

}
