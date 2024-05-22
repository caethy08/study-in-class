package pack3;

public class Ex12Father extends Ex12GrandFa {//단일 상속만 가능
	//Ex12GrandFa fa = new Ex12GrandFa(); //적으면 포함관계
	
	public String gabo = "꽃병";//은닉화
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
		super(); //생략 시 매개변수(parmeter)가 없는 부모 생성자 호출 
		//super(55);  는 int타입 매개변수를 가진 부모생성자 호출
		System.out.println("아버지 생성자");
		
	}
	
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
	@Override //오버라이드 어노테이션: 오버라이딩을 체크하는 기능을 가짐>메소드, 필수 아님
	public int getNai() { //method overriding 부모와 같은 메소드 생성
		return nai;
	}
	
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라";
	}
	
	final public String getHouse() {//메소드에 final하면 자식 클래스에서 오버라이딩 불가
		return "집 : "  + house + "채";
	}
	
	public void showData() {
		System.out.println("아버지 나이 " + nai);//블럭내에서 지역변수를 먼저 찾음>없을 경우 멤버필드에서 찾음
		System.out.println("아버지 나이 " + this.nai); //처음부터 멤버필드로 직행해서 찾음
		System.out.println("아버지 나이 " + getNai());//현재클래스에서 겟나이 찾다가 없어서 부모클래스에서 찾음
		System.out.println("아버지 나이 " + this.getNai());//바로 위와 동일
		//전부 같은 값을 가짐
		//System.out.println("할아버지 나이 " + super.Nai()); //오류
		System.out.println("할아버지 나이 " + super.getNai());//super. 은 처음부터 부모클래스에게 가는 것
		
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo);
		System.out.println("가보 " + this.gabo);//현재 클래스의 전역변수를 찾다가 없으면 부모클래스로 감
		System.out.println("가보 " + super.gabo);

	}
}
