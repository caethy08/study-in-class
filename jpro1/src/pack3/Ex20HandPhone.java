package pack3;

public class Ex20HandPhone implements Ex20Volume {
	private int volLevel;
	
	public Ex20HandPhone() {
		volLevel = 0;
	}
	
	@Override
	public void volumeUp(int Level) {
		// 인터페이스의 추상메소드를 오버라이딩
		if (Level > 100) Level = 100;
		volLevel += Level;
		System.out.println("핸드폰 볼륨을 올리면 " + volLevel);		
	}
	
	@Override
	public void volumeDown(int Level) {
		volLevel -= Level;
		if (volLevel < 0) volLevel = 0;
		System.out.println("핸드폰 볼륨을 내리면 " + volLevel);
	}
}
