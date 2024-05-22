package pack1;

public class Ex2Car {
	private int speed;
	public String irum;
	private double weight; //==private double weight = 0.0; >  캡슐화
	
	public Ex2Car() {
		irum = "홍길동"; //생성자
		speed = 10;
		
	}
	
	public void showData() {
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}
	
	//public void abcd(int s, int password) {//private 멤버값을 외부에서 접근하기 위한 메소드, password를 걸수도 있다.
	public void setSpeed(int s) { //speed에게만 집중. setter 매소드
			speed = s;
			//return; 반환이 없으면 안적어도 된다.
	}
	public int getSpeed() {//getter 메소드. 메소드의 타입과 return값은 같아야 한다(speed는 int값을 쓴다)
		return speed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		//멤버필드 weight에 지역변수 weight값을 치환 지역변수와 멤버필드(전역변수)의 이름이 같을 때 구분을 위해 this사용
	}
	
	

}
