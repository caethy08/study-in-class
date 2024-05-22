package pack3;

public class Ex17Main {

	public static void main(String[] args) {
		// 추상 클래스 연습
		//Ex17Jepum jepum = new Ex17Jepum(); //추상 클래스는 인스턴스 불가(자체적인 의미 안가짐, 오직 부모로만 존재)
		Ex17Jepum jepum = null; //Ex17Jepum jepum;과 같은 의미
		
		Ex17Radio radio = new Ex17Radio();
		jepum = radio;
		jepum.volumeControl();
		
		System.out.println();
		Ex17Tv tv = new Ex17Tv();
		jepum = tv;
		jepum.volumeControl();
		
		
		System.out.println();
		Ex17Jepum jepumArr[] = {radio, tv};
		for(Ex17Jepum j:jepumArr) {
			j.volumeControl();
		}
	}

}
