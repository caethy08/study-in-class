package pack1;

public class Ex6Main {

	public static void main(String[] args) {
		// 같은 패키지에 있는 Ex6Bank 클래스를 사용
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액: " + kildong.getMoney());
		//kildong.money;//에러 : private 멤버이므로 해당 클래스에서만 참조 가능
		System.err.println("a:" + kildong.a); //default > 가능
		System.err.println("b:" + kildong.b); //public > 가능
		
		System.out.println();
		Ex6Bank dajeong = new Ex6Bank(2000);
		dajeong.dePosit(5000);
		dajeong.withDraw(2000);
		System.out.println("dajeong 예금액: " + dajeong.getMoney());

		System.out.println("객체 주소 관련-------");
		System.out.println("kildong 주소 : " + kildong /* + " " + kildong.hashCode()은 주소를 십진법으로 표현해주는 코드*/);
		System.out.println("dajeong 주소 : " + dajeong);
		
		Ex6Bank tom = null; //Ex6Bank tom; 과 동일
		System.out.println("tom의 주소 : " + tom);
		//System.out.println("tom 예금액 : " + tom.getMoney()); //nullpointexception : 객체변수는 있지만 어떤 인스턴스의 주소도 가지고 있지 않은 상태
		tom = dajeong; //주소 치환. 하나의 인스턴스를 2개의 동일한 타입의 변수가 참조하는 것  기본형은 값을, 참조형은 주소를 공유한다
		System.out.println("tom 예금액 : " + tom.getMoney());
		
		if (dajeong == kildong) {//참조형변수의 ==은 주소비교, 기본형은 값 비교
			System.out.println("둘은 같은 주소임을 알림");
		}else {
			System.out.println("둘은 다른 주소야~~~");
		}
		
		System.out.println(dajeong instanceof Ex6Bank);
		
		if (dajeong instanceof Ex6Bank) {
			//instanceof : 객체 타입 비교 연산자
			System.out.println("Ex6Bank 타입이 맞아요");
		}else {
			System.out.println("ㅠㅠ Ex6Bank 타입이 아니군요");
		}
		
		System.out.println("\n스트링(String) 타입의 값 비교----");
		String ss1 = "kor"; 
		//string 클래스 : 참조형이지만 기본형처럼 사용할 수 있도록 자바가 배려함 literal pool에 인스턴스 생성
		String ss2 = new String(); //생성자를 만들고 값을 줌. literal pool에 인스턴스 생성
		ss2 = "kor";
		String ss3 = new String("kor"); //생성자를 통해 값을 밀어넣음. heap에 인스턴스 생성
		
		System.out.println(ss1 + " " + ss2 + " " + ss3);
		
		if (ss1 == ss2) //String을 비교할때는 == 사용 안함 .
			System.out.println("같음1");
		else
			System.out.println("다름1");
		
		if (ss1 == ss3) 
			System.out.println("같음2");
		else
			System.out.println("다름2");
		
		//그러므로 String은 주소 비교가 아니라 값을 비교하는 것이 목적이므로 equals() 사용
		if (ss1.equals(ss2)) //값 비교 
			System.out.println("같음3");
		else
			System.out.println("다름3");
		
		if (ss1.equals(ss3)) //값 비교 
			System.out.println("같음4");
		else
			System.out.println("다름4");
		
		if (ss1.equalsIgnoreCase(ss3)) //값 비교 (영문 대소문자 구분 안함)
			System.out.println("같음4");
		else
			System.out.println("다름4");
	}

}
