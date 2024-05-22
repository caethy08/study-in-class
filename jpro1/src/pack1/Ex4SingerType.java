package pack1;

//값을 직접적으로 선언하는 것: 일회용
public class Ex4SingerType {
	private String name = "무명 가수"; //이름
	private String title = "아 대한민국"; //곡 제목  
	//...
	
	//생성자를 통해 멤버 변수에 값 저장 
	public Ex4SingerType(String name, String title) {
		//this.name = "bts"; 그동안은 "bts"값은 name에 직접 주었지만 위(String name, String title)에서 값을 받기로 함
		this.name = name;
		this.title = title;
	}
	public String getName() { // getter
		return name;
	}
	public String getTitle() {
		return title;
	}
	
	private void sing() {
		System.out.println(name + " is singing " + title + "...");

	}
	
	public static void main(String[] args) {
		//응용 프로그램 시작용 메소드
		//Ex4SingerType 멤버는 아님
		Ex4SingerType bts = new Ex4SingerType("bts", "Dynamite");
		bts.sing();
		System.out.println("가수 이름 : " + bts.getName());//이름만 찍고싶으면 getName > 선택적
		System.out.println("곡 제목 : " + bts.getTitle());//곡 제목만 찍고싶으면 getTitle
		
		System.out.println();
		Ex4SingerType blackpink = new Ex4SingerType("blackpink", "How you like that");
		blackpink.sing();
		System.out.println("가수 이름 : " + blackpink.getName());
		System.out.println("곡 제목 : " + blackpink.getTitle());
	}

}
