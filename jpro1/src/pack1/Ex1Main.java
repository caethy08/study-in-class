package pack1;

public class Ex1Main { //응용 프로그램의 시작, 즉 main을위한 클래스일 뿐.

	public static void main(String[] args) {
		System.out.println("이런 저런 작업을 하다가....");
		int a = 1; //(타입)(변수명) = (값)은 만들어져있기 때문에 new 생략(api)
		System.out.println("기본형 변수 a가 기억한 값:" + a);
		
		System.out.println();
		//자동차 객체를 만들고 싶어...
		Ex1Car car1 = new Ex1Car();  //클래스 --> 인스턴스화 --->인스턴스(객체) 
		//기존에 없었기에 새로 만들기 위해 new를 붙여 끌어올림
		//보조 기억장치에 있던 Ex1Car.class를 메인 RAM(주기억 장치)로 로딩
		//car1 : 객체 변수 - 객체의 주소를 기억
		//new : 인스턴스화를 위한 키워드
		//Ex1Car() : 생성자를 호출
		System.out.println("Ex1Car 타입의 생성된 객체 주소:" + car1);
		System.out.println("바퀴 수 : " + car1.wheel);
		car1.abc();
		//car1.def(); private 이므로 호출 불가
		System.out.println("객체 하나 더 생성----"); //같은 타입이어도 객체의 주소는 다를 수 있다.
		Ex1Car car2 = new Ex1Car();
		System.out.println("Ex1Car 타입의 생성된 객체 주소 cae2:" + car2);
		System.out.println("바퀴 수 : " + car2.wheel);
		car2.abc();
		
		System.out.println();
		System.out.println(car1.getClass()); //객체변수 타입 확인
		System.out.println(car2.getClass());
		System.out.println(car1.getClass() == car2.getClass()); //타입 비교
		System.out.println(car1 == car2); //주소 비교

	}

}
