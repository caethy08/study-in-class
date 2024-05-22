package Pack6thread;

public class Ex42BreadMain {

	public static void main(String[] args) {
		// 스레드간 자원 공유 및 스레드 활성화/비활성화 연습
		EX42BreadPlate breadplate = new EX42BreadPlate();
		
		Ex42BreadMaker maker = new Ex42BreadMaker(breadplate);
		Ex42BreadEater eater = new Ex42BreadEater(breadplate);
		
		//maker.run(): 싱클 태스킹
		//eater.start();
		maker.start(); //멀티 태스킹
		eater.start();
	}

}
