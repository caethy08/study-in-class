package Pack6thread;

public class Ex42BreadMaker extends Thread{ //빵 생산자
	private EX42BreadPlate plate;
	
	public Ex42BreadMaker(EX42BreadPlate plate) {
		this.plate = plate; //생성자를 통해 인스턴스의주소를 받아옴
	}
	
	@Override //런메소드 오버라이드
		public void run() {
			for (int i = 0; i < 30; i++) {
				plate.makeBread();
			}
		}

}
