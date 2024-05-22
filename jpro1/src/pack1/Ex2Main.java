package pack1;

public class Ex2Main {

	public static void main(String[] args) {
		// getter, setter 연습
		System.out.println("프로그램을 실행하다가...");
		//Ex2Car 객체열 만들기
		System.out.println();
		Ex2Car tom = new Ex2Car(); //객체변수 tom
		tom.showData();
		System.out.println("이름은 " + tom.irum); //irum은 public이어서 같은 패키지 내에 있어서 부를 수 있다.
		tom.irum = "미스터 톰"; //public은 클래스 밖에서 부를 수 있어서(참조할 수 있어서) 접근이 가능
		System.out.println("이름은 " + tom.irum);
		System.out.println("갯터, 셋터 확인");
		//tom.speed = 80; //private이므로 접근 불가능 메소드 != 행동
		//tom.abcd(80, 123); //private인 speed는 접근 불가능하기 때문에 abcd로 캡슐화 시켜서 퍼블릭 메소드를 사용해 접근 예를 들어 비밀번호에 의해 수정결정
		tom.setSpeed(80); //speed에게만 집중
		tom.showData(); 
		//System.out.println("속도는 " + tom.speed); //speed는 private여서 접근 금지
		System.out.println("속도는 " + tom.getSpeed()); 
		int result = tom.getSpeed();
		System.out.println("속도는 " + result);
	}

}
