package pack3;

public class Ex23FlyerUtil {
	public static void show(Ex23Flyer f) {//show메소드가 참조형 ex23flyer의 객체 f를 달라고 함
		f.fly();
		System.out.println("동물인가요?" + f.isAnimal());
	}
}
