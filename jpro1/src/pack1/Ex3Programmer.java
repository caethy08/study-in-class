package pack1;

public class Ex3Programmer {
	//public String nickName = "";
	public String nickName;  //초기 값은 null < 참조형
	//private int age = 0;
	private int age;  //초기 값은0  <기본형이어서
	String spec = "자바"; //여기까지 멤버필드
	
	public static String motto = "자바에 미쳐 버리자";//motto는 static(기타 지정자)가 되었다
	public final String campName = "에이콘 아카데미"; //final을 붙이면 이후 수정 불가 > 상수(final string campname) = literal(에이콘 아카데미)
	
	public Ex3Programmer() {//생성자
		System.out.println("난 생성자야 역할은 객체 생성시 초기화를 담당해");
		System.out.println("초기화 없을 때는 생략 가능");
		age = 22;
		//displayData();//생성자가 밑에서 메소드를 불러옴
		//campName = "도토리";  위에서 final을 붙여서
		System.out.println("캠프 이름 : " + campName);
	}
	
	public void displayData() {//메소드. displayDaya()는 Ex3Programmer의 멤버지만 앞에 public을 붙여 private데이터에 접근 가능하게 만든다
		System.out.println("별명이 " + nickName + ", 나이는 " + age + "살, 보유 기술은 " + spec);
		//지역내에서 먼저 찾고> 멤버필드에서 찾음
		System.out.println("보유 기술 재 확인 : " + showSpec());
	}
	
	private String showSpec() {//showSpec은 캡슐화 시켜서 현재 클래스 내에서만 사용 가능. 반환 값인 spec이 문자열이기 때문에 String
		String msg = "프로그래밍 언어 : " + spec;
		return msg + "(커피 아님)"; //반환(return)할 때는 하나만 가능(그 이상을 원할 경우 배열 사용)
	}
	//private age에 대한 getter, setter <데이터에 접근하기 위해서는 만들어 줘야함
	public void setAge(int age) {
		//age = age; 지역변수에게 지역변수를 줌
		this.age = age;
	}
	
	public int getAge() {
		return age; 
	}
	
	static public void goodMethod() {
		System.out.println("스테틱 메모리 임을 널리 알리노라");
		System.err.println(motto); 
		//System.out.println(age); //에러. static메소드는  스테틱 멤버만 호출 가능 일반 멤버 호출 불가
	}
	
	private void niceMethd() {
		System.out.println(age);  //일반 메소드는 일반 멤버 호출 가능
		System.err.println(motto); //일반 메소드는 static 멤버 호출 가능
	}
}
