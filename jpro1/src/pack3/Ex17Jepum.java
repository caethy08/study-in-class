package pack3;

abstract public class Ex17Jepum {
	//가전 제품의 원형 클래스 : 추상 클래스
	public int volume = 0;
	
	public Ex17Jepum() {
		System.out.println("추상 클래스 생성자");
	}
	
	abstract public void volumeControl(); //body가 없는 메소드: 추상 메소드
	//자식 클래스에서 반드시 오버라이딩 하도록 강요
	
	public void volumeShow() {
		System.out.println("소리 크기는 " + volume);
		//오버라이딩 선택 가능
	}
}
