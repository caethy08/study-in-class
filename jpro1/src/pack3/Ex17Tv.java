package pack3;

public class Ex17Tv extends Ex17Jepum {
	public Ex17Tv() {
		System.out.println("Tv 생성자");
	}
	
	@Override
	public void volumeControl() {
		//오버라이드 강요 당함
		System.out.println("Tv 소리 조정");		
	}
	@Override
	public void volumeShow() {
		//오버라이딩 선택 
		System.out.println("소리 크기는 적당히 : 부모 메소드 대신 새로운 내용으로 대체");		
	}
}
