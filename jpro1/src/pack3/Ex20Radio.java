package pack3;

public class Ex20Radio implements Ex20Volume {
	private int volLevel;
	
	public Ex20Radio() {
		volLevel = 0;
	}
	
	@Override
	public void volumeUp(int Level) {
		// 인터페이스의 추상메소드를 오버라이딩
		volLevel += Level;
		System.out.println("라디오 볼륨을 올리면 " + volLevel);		
	}
	
	@Override
	public void volumeDown(int Level) {
		volLevel -= Level;
		System.out.println("라디오 볼륨을 내리면 " + volLevel);
	}
}
