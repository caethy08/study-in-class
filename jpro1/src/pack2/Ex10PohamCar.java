package pack2;

public class Ex10PohamCar {
	//여러개의 부품이 모여서 완성된 차 설계도(class)
	int speed = 0; //멤버필드
	String ownerName, turnMessageShow; //멤버필드
	Ex10PohamHandle handle; //class ex10pohamhandle을 멤버필드처럼 사용  부품 클래스를 자신의 멤버처럼 사용
	
	public Ex10PohamCar() {
		// handle사용 불가 > 객체 생성하지 않음
		
	}
	
	public Ex10PohamCar(String name) {//생성자 오버로딩
		ownerName = name; //멤버필드 ownername에 지역변수 name의 값을 준다
		handle = new Ex10PohamHandle(); //클래스의 포함관계(has a 관계). 객체 생성자
		
	}
	
	public void playCarTurnHandle(int q) {//q: 핸들 회전량
		if(q > 0) {
		turnMessageShow = handle.rightTurn(q); //handle에 있는 Rightturn을 불러 사용
		}
		
		if(q < 0) turnMessageShow = handle.leftTurn(q); 
		
		if(q == 0) turnMessageShow = handle.straight(q); 		
	}
}
