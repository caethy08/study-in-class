package pack3;

public class Ex20Tv implements Ex20Volume {
	private int volLevel;
	
	public Ex20Tv() {
		volLevel = 0;
	}
	
	@Override
	public void volumeUp(int Level) {
		// 인터페이스의 추상메소드를 오버라이딩
		volLevel += Level;
		String msg = "Tv 볼륨을 올리면";
		System.out.println(msg + volLevel);		
	}
	
	@Override
	public void volumeDown(int Level) {
		volLevel -= Level;
		String msg = "Tv 볼륨을 내리면 ";
		System.out.println(msg + volLevel);
	}
}
