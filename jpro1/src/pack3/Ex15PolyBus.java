package pack3;

public class Ex15PolyBus extends Ex15PolyCar {
	private int passenger = 10;
	
	
	public void show() {//ex15polybus의 고유 메소드
		System.out.println("버스");
	}
	
	@Override //Annotation, 메타데이터: 컴파일러에게 정보를 알려주는 역할
	public void displaySpeed() {
		System.out.println("버스 승객 수는 " + passenger);
		System.out.println("버스의 속도는 " + speed);
	}//같은 이름의 메소드여도 다양한 역할을 줄 수 있다. 다형성
}
