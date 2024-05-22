package pack1; //package =폴더

//접근 지정자
//-public : 같은 프로젝트 내에서 유효하다. package가 달라도 됨
//-protected : 같은 프로젝트 내에서 우효. 패키지가 다른 경우 자식 클래스만 유효
//-default : 같은 패키지 내에서만 유효
//-private(-) : 현재 클래스 내에서만 유효. 다른 클래스에서는 참조 불가

public class Ex1Car {//[접근 지정자][기타제한자] class 클래스명(파일 명과 같아야한다.)
	int wheel; //멤버 필드(전역 변수) : default 접근 지정자(앞에 접근 지정자가 없음) 초기치는 0.
	private int airbag = 1; //[접근지정자][기타제한자] 타입 변수명
	private int speed;      //private하고 주면 캡슐화
	public String irum;
	
	public Ex1Car() { 
	//클래스와 이름이 같고 반환형이 없는 메소드 : 생성자: 객체 생성 시 new로 1회호출 가능. 적을 내용이 없다면 안적어도 된다(없어도 된다는 소리 아님!!!)
		System.out.println("생성자 : 객체 생성시 초기화를 담당. 1회 호출됨");
		wheel = 4; //생성자가 호출되고 wheel이 4로 변환> 생성자 종료
	}
	
	public void abc() {// [접근 지정자][기타제한자] 반환타입(형) 메소드명([타입 매개변수...])
		System.out.println("abc 메소드 수행");
		System.out.println("에어백 수는 " + airbag);
		def(); //private 멤버는 현재 클래스 내에서만 사용 가능
	}
	
	private void def() {//같은 클래스 내에서만 사용 가능. 보안 강화 목적
		System.out.println("def 메소드 수행");
	}

}
