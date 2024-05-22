package pack3;

/*
 * 추상 메소드와 상수로 구성된 클래스
 * 다중 상속이 가능
 * 인터페이스는 인스턴스(new)할 수 없다
 * 인터페이스는 자식클래스에서 implements 키워드로 구현(상속과 같지만 구분 위해 사용)한다.
 * 인터페이스 간 상속이 가능
 */

public interface Ex20Volume {
	void volumeUp (int Level);  //public abstract void volumeUp(int level); 을 의미함. 
	void volumeDown (int Level);
	
	/*
	void print() {
		//일반 메소드는 사용할 수 없다.
	}
	*/
}
