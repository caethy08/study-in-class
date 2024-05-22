package pack3;

//인터페이스를 구형하고 모든 추상 메소드를 오버라이드 해야하는 지옥에서 벗어날 수 있다. 
//추상을 일반 메소드로 만들어 둔 adapter 클래스를 상속 받아 선택적으로 메소드를 작성할수 있다.
//public class Ex23Ball implements Ex23Flyer {
public class Ex23Ball extends Ex23FlyerAdapter{
	@Override
	public void fly() {
		System.out.println("공이 관중석으로 날아감");
	}

}
