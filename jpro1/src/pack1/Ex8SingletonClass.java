package pack1;

import java.security.PublicKey;

public class Ex8SingletonClass {//클래스 선언
	int kor = 90;
	
	public Ex8SingletonClass() {//생성자
		// TODO Auto-generated method stub

	}
	
	//객체의 인스턴스가 오직 1개만 생성되는 패턴을 만들기 여러 데이터에서 접근
	//강점 : 메모리 절약, 데이터 공유 관리
	//단점: 테스트가 불편, 유연성이 떨어짐
	
	private static Ex8SingletonClass class1 = new Ex8SingletonClass(); //생성자
	
	public static Ex8SingletonClass getInstence() {//static으로 클래스 호출
		return class1;
	
	}

}
