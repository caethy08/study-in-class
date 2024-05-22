package Pack6thread;

public class Ex42BreadEater extends Thread{ //빵 소비자
	private EX42BreadPlate plate;
	
	public Ex42BreadEater(EX42BreadPlate plate) {
		this.plate = plate; //생성자를 통해 인스턴스의주소를 넘겨받음
	}
	
	@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
				plate.eatBread();
			}
		}

}
