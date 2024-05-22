package pack1;

//method overload : 한 개의 클래스의 이름이 같은 메소드를 여러 개 선언 
//성립 조건 : 매개변수의 갯수, 타입, 순서가 다르면 된다. 반환형과는 관계가 없다.

public class Ex5AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1; //final멤버필드는 대문자로 적기
	
	public Ex5AnimalOverload() {	
		//기본형 생성자		//생성자는 내용이 없는 경우 생략 가능	 argument가 없는 생성자를 적어둔다
		this(10); //생성자가 다른 생성자를 호출하는 것
		System.out.println("비어 있는 생성자");
		
		//메소드명();  //생성자가 메소드를 호출
	}
	public Ex5AnimalOverload(int leg) {
	//생성자 오버로딩. 객체를 만들면서 선택적으로 값을 줄 수 있다. 처음 한번 밖에 값을 바꿀 수 없다.
			this.leg = leg;
	}
	
	public Ex5AnimalOverload(String name) {	
	//생성자 오버로딩. 객체를 만들면서 선택적으로 값을 줄 수 있다. 처음 한번 밖에 값을 바꿀 수 없다.
		this.name = name;
}
	public Ex5AnimalOverload(String name, int age, int leg) {
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
	//-----------------------------------------------------------
	public void display() {
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	//method overloading
	public void display(int age) {
		//클래스 내에 동일 매소드가 2개 이상 있으면 에러, 클래스도 마찬가지. 
		//매개변수(parameter)의 타입, 갯수, 순서 중 하나가 다를 경우 성립
		this.age = age; //지역변수 age를 멤버필드 age에 기억
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(String name) {
		//this.age = age; //지역변수 age를 멤버필드 age에 기억
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(String name, int age) {//위와 갯수는 같지만 타입이 달라서 성립 
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	public void display(int age, String name) {//위와 갯수는 같지만 순서가 달라서 성립
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	/*
	public void display(int leg) { //타입과 갯수가 동일해서 에러
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	
	
	public String display(int leg) {//반환형과는 관계없이 매개변수와 동일해서 에러
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	*/
}	
