package pack1;

public class Ex3main {

	public static void main(String[] args) {
		// 클래스 기본 연습 중
		Ex3Programmer programmer = new Ex3Programmer(); //생성자. 인스턴스화 시키는 명령문
		//명령어(Static)+ 변수      = new 인스턴스
		programmer.displayData();
		
		System.out.println();
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
		programmer.displayData();
		
		System.out.println("------");
		Ex3Programmer tom = new Ex3Programmer(); //생성자 호출
		tom.nickName = "톰 아저씨";
		tom.displayData();
		
		System.out.println("------");
		Ex3Programmer james = new Ex3Programmer(); //생성자 호출
		tom.nickName = "제임스 형";
		tom.displayData();
		
		System.out.println();
		System.out.println("너의 모토는" + james.motto);
		//static멤버는 클래스이름.멤버 하고 사용한다.(권장)
		System.out.println("너의 모토는" + Ex3Programmer.motto); //out도 스테틱 멤버인데 클래스 이름으로 불리는 중
		Ex3Programmer.goodMethod(); //스테틱은 기울임체로 변경, 용량이 적어서 꼭 필요한 것만 static으로 변경
	
		
	}

}
