package pack2;

public class Ex10CarMain {

	public static void main(String[] args) {
		//클래스의 포함관계 연습 (운전)
		Ex10PohamCar tom = new Ex10PohamCar("미스터 톰"); //생성자
		tom.playCarTurnHandle(30);
		System.out.println(tom.ownerName + "의 회전량은 " + tom.turnMessageShow + " " + tom.handle.quantity);
		//톰안에 handle클래스가 있고 그 클래스 안에 quantity가 있음 .이 2개면 클래스의 상속관계
		
		tom.playCarTurnHandle(-20);
		System.out.println(tom.ownerName + "의 회전량은 " + tom.turnMessageShow + " " + tom.handle.quantity);
		
		System.out.println();
		Ex10PohamCar james = new Ex10PohamCar("제임스 삼촌"); //생성자
		james.playCarTurnHandle(0);
		System.out.println(james.ownerName + "의 회전량은 " + james.turnMessageShow + " " + james.handle.quantity);
	
	}

}
